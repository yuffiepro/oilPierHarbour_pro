<template>
  <div class="app-wrapper">
    <!-- 侧边栏 -->
    <div class="sidebar-container" :class="{ 'collapsed': isCollapse }">
      <div class="logo">
        <img src="@/assets/logo.png" alt="Logo" v-if="!isCollapse">
        <span v-if="!isCollapse">油墩港平台</span>
      </div>
      
      <el-menu
        :default-active="activeMenu"
        :collapse="isCollapse"
        :unique-opened="true"
        router
        class="sidebar-menu"
      >
        <el-menu-item
          v-for="route in routes"
          :key="route.path"
          :index="route.path"
          :title="route.meta?.title"
        >
          <el-icon><component :is="route.meta?.icon" /></el-icon>
          <template #title>{{ route.meta?.title }}</template>
        </el-menu-item>
      </el-menu>
    </div>

    <!-- 主内容区 -->
    <div class="main-container">
      <!-- 顶部导航栏 -->
      <div class="navbar">
        <div class="left">
          <el-button
            type="text"
            @click="toggleSidebar"
            class="collapse-btn"
          >
            <el-icon><Fold v-if="!isCollapse" /><Expand v-else /></el-icon>
          </el-button>
          
          <el-breadcrumb separator="/">
            <el-breadcrumb-item v-for="item in breadcrumbs" :key="item.path">
              {{ item.title }}
            </el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        
        <div class="right">
          <el-dropdown>
            <span class="user-info">
              <el-avatar size="small" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png" />
              <span>管理员</span>
            </span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item>个人信息</el-dropdown-item>
                <el-dropdown-item>修改密码</el-dropdown-item>
                <el-dropdown-item divided>退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </div>
      </div>

      <!-- 内容区域 -->
      <div class="app-main">
        <router-view />
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import type { RouteRecordRaw } from 'vue-router'

const route = useRoute()
const router = useRouter()

// 侧边栏折叠状态
const isCollapse = ref(false)

// 获取路由配置
const routes = computed(() => {
  const mainRoute = router.getRoutes().find(r => r.name === 'Layout')
  return mainRoute?.children || []
})

// 当前激活的菜单
const activeMenu = computed(() => route.path)

// 面包屑导航
const breadcrumbs = computed(() => {
  const matched = route.matched.filter(item => item.meta?.title)
  return matched.map(item => ({
    title: item.meta?.title,
    path: item.path
  }))
})

// 切换侧边栏
const toggleSidebar = () => {
  isCollapse.value = !isCollapse.value
}
</script>

<style lang="scss" scoped>
.app-wrapper {
  display: flex;
  height: 100vh;
  width: 100vw;
}

.sidebar-container {
  width: 240px;
  background: #304156;
  transition: width 0.3s;
  
  &.collapsed {
    width: 64px;
  }
  
  .logo {
    height: 60px;
    display: flex;
    align-items: center;
    justify-content: center;
    color: #fff;
    font-size: 18px;
    font-weight: bold;
    
    img {
      width: 32px;
      height: 32px;
      margin-right: 8px;
    }
  }
  
  .sidebar-menu {
    border: none;
    background: transparent;
    
    :deep(.el-menu-item) {
      color: #bfcbd9;
      
      &:hover, &.is-active {
        background: #263445;
        color: #409eff;
      }
    }
  }
}

.main-container {
  flex: 1;
  display: flex;
  flex-direction: column;
  overflow: hidden;
}

.navbar {
  height: 60px;
  background: #fff;
  border-bottom: 1px solid #e6e6e6;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 20px;
  
  .left {
    display: flex;
    align-items: center;
    
    .collapse-btn {
      margin-right: 20px;
    }
  }
  
  .right {
    .user-info {
      display: flex;
      align-items: center;
      cursor: pointer;
      
      span {
        margin-left: 8px;
      }
    }
  }
}

.app-main {
  flex: 1;
  padding: 20px;
  overflow: auto;
  background: #f0f2f5;
}
</style>
