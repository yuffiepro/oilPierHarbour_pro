<template>
  <div class="system-settings">
    <div class="page-header">
      <h2>系统设置</h2>
      <p>配置系统参数和用户权限管理</p>
    </div>

    <div class="settings-content">
      <el-tabs v-model="activeTab" type="border-card">
        <el-tab-pane label="基本设置" name="basic">
          <div class="settings-section">
            <h3>系统基本信息</h3>
            <el-form :model="basicSettings" label-width="120px">
              <el-form-item label="系统名称">
                <el-input v-model="basicSettings.systemName" />
              </el-form-item>
              <el-form-item label="系统版本">
                <el-input v-model="basicSettings.version" disabled />
              </el-form-item>
              <el-form-item label="管理员邮箱">
                <el-input v-model="basicSettings.adminEmail" />
              </el-form-item>
              <el-form-item label="系统描述">
                <el-input v-model="basicSettings.description" type="textarea" />
              </el-form-item>
            </el-form>
          </div>
        </el-tab-pane>

        <el-tab-pane label="用户管理" name="users">
          <div class="settings-section">
            <h3>用户列表</h3>
            <el-table :data="userList" style="width: 100%">
              <el-table-column prop="username" label="用户名" />
              <el-table-column prop="role" label="角色" />
              <el-table-column prop="status" label="状态">
                <template #default="{ row }">
                  <el-tag :type="row.status === '启用' ? 'success' : 'danger'">
                    {{ row.status }}
                  </el-tag>
                </template>
              </el-table-column>
              <el-table-column prop="lastLogin" label="最后登录" />
              <el-table-column label="操作">
                <template #default="{ row }">
                  <el-button size="small" @click="editUser(row)">编辑</el-button>
                  <el-button size="small" type="danger" @click="deleteUser(row)">删除</el-button>
                </template>
              </el-table-column>
            </el-table>
          </div>
        </el-tab-pane>

        <el-tab-pane label="权限设置" name="permissions">
          <div class="settings-section">
            <h3>角色权限配置</h3>
            <el-tree
              :data="permissionTree"
              show-checkbox
              node-key="id"
              :default-checked-keys="checkedPermissions"
              :props="defaultProps"
            />
          </div>
        </el-tab-pane>

        <el-tab-pane label="系统监控" name="monitoring">
          <div class="settings-section">
            <h3>系统运行状态</h3>
            <div class="monitoring-grid">
              <div class="monitoring-item">
                <span class="label">CPU使用率:</span>
                <span class="value">45%</span>
              </div>
              <div class="monitoring-item">
                <span class="label">内存使用率:</span>
                <span class="value">68%</span>
              </div>
              <div class="monitoring-item">
                <span class="label">磁盘使用率:</span>
                <span class="value">52%</span>
              </div>
              <div class="monitoring-item">
                <span class="label">网络状态:</span>
                <span class="value">正常</span>
              </div>
            </div>
          </div>
        </el-tab-pane>
      </el-tabs>

      <div class="actions">
        <el-button type="primary" @click="saveSettings">保存设置</el-button>
        <el-button @click="resetSettings">重置</el-button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const activeTab = ref('basic')

const basicSettings = ref({
  systemName: '油墩港数字管理平台',
  version: '1.0.0',
  adminEmail: 'admin@oilpier.com',
  description: '综合性的港口数字管理平台，提供全方位的监测和管理功能'
})

const userList = ref([
  { username: 'admin', role: '超级管理员', status: '启用', lastLogin: '2023-08-15 14:30' },
  { username: 'operator', role: '操作员', status: '启用', lastLogin: '2023-08-15 13:45' },
  { username: 'viewer', role: '查看者', status: '启用', lastLogin: '2023-08-15 12:20' }
])

const permissionTree = ref([
  {
    id: 1,
    label: '系统管理',
    children: [
      { id: 11, label: '用户管理' },
      { id: 12, label: '角色管理' },
      { id: 13, label: '权限配置' }
    ]
  },
  {
    id: 2,
    label: '监测管理',
    children: [
      { id: 21, label: '桥梁监测' },
      { id: 22, label: '塔吊监测' },
      { id: 23, label: '水质监测' }
    ]
  }
])

const checkedPermissions = ref([11, 21, 22])

const defaultProps = {
  children: 'children',
  label: 'label'
}

const editUser = (user) => {
  console.log('编辑用户:', user)
}

const deleteUser = (user) => {
  console.log('删除用户:', user)
}

const saveSettings = () => {
  console.log('保存设置')
}

const resetSettings = () => {
  console.log('重置设置')
}
</script>

<style scoped>
.system-settings {
  max-width: 1200px;
  margin: 0 auto;
}

.page-header {
  text-align: center;
  margin-bottom: 30px;
  padding: 30px;
  background: white;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}

.page-header h2 {
  color: #333;
  margin-bottom: 12px;
  font-size: 28px;
}

.page-header p {
  color: #666;
  font-size: 16px;
  margin: 0;
}

.settings-content {
  background: white;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
  overflow: hidden;
}

.settings-section {
  padding: 20px;
}

.settings-section h3 {
  margin: 0 0 20px 0;
  color: #333;
  font-size: 18px;
}

.monitoring-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 20px;
}

.monitoring-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 16px;
  background: #f8f9fa;
  border-radius: 8px;
}

.monitoring-item .label {
  color: #666;
  font-size: 14px;
}

.monitoring-item .value {
  color: #333;
  font-size: 16px;
  font-weight: bold;
}

.actions {
  padding: 20px;
  text-align: center;
  border-top: 1px solid #e6e6e6;
}
</style>
