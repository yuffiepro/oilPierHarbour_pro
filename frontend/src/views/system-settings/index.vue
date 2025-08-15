<template>
  <div class="system-settings">
    <div class="page-header">
      <h2>系统设置</h2>
      <p>配置系统参数和用户权限管理</p>
    </div>

    <div class="settings-content">
      <div class="settings-section">
        <h3>基本设置</h3>
        <div class="settings-form">
          <div class="form-item">
            <label>系统名称</label>
            <el-input v-model="systemName" placeholder="请输入系统名称" />
          </div>
          <div class="form-item">
            <label>系统版本</label>
            <el-input v-model="systemVersion" placeholder="系统版本" disabled />
          </div>
          <div class="form-item">
            <label>管理员邮箱</label>
            <el-input v-model="adminEmail" placeholder="请输入管理员邮箱" />
          </div>
        </div>
      </div>

      <div class="settings-section">
        <h3>安全设置</h3>
        <div class="settings-form">
          <div class="form-item">
            <label>密码最小长度</label>
            <el-input-number v-model="minPasswordLength" :min="6" :max="20" />
          </div>
          <div class="form-item">
            <label>会话超时时间</label>
            <el-select v-model="sessionTimeout">
              <el-option label="30分钟" value="30" />
              <el-option label="1小时" value="60" />
              <el-option label="2小时" value="120" />
            </el-select>
          </div>
        </div>
      </div>

      <div class="settings-section">
        <h3>通知设置</h3>
        <div class="settings-form">
          <div class="form-item">
            <label>邮件通知</label>
            <el-switch v-model="emailNotification" />
          </div>
          <div class="form-item">
            <label>短信通知</label>
            <el-switch v-model="smsNotification" />
          </div>
        </div>
      </div>

      <div class="action-buttons">
        <el-button type="primary" @click="saveSettings">保存设置</el-button>
        <el-button @click="resetSettings">重置设置</el-button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const systemName = ref('油墩港数字管理平台')
const systemVersion = ref('1.0.0')
const adminEmail = ref('admin@oilpier.com')
const minPasswordLength = ref(8)
const sessionTimeout = ref('60')
const emailNotification = ref(true)
const smsNotification = ref(false)

const saveSettings = () => {
  // 保存设置逻辑
  console.log('保存设置')
}

const resetSettings = () => {
  // 重置设置逻辑
  console.log('重置设置')
}
</script>

<style scoped>
.system-settings {
  max-width: 800px;
  margin: 0 auto;
}

.page-header {
  text-align: center;
  margin-bottom: 40px;
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
  display: flex;
  flex-direction: column;
  gap: 30px;
}

.settings-section {
  background: white;
  padding: 30px;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}

.settings-section h3 {
  margin: 0 0 24px 0;
  color: #333;
  font-size: 20px;
}

.settings-form {
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.form-item {
  display: flex;
  flex-direction: column;
  gap: 8px;
}

.form-item label {
  color: #333;
  font-size: 14px;
  font-weight: 500;
}

.action-buttons {
  display: flex;
  gap: 16px;
  justify-content: center;
  padding: 20px;
}

.action-buttons .el-button {
  min-width: 120px;
}
</style>

