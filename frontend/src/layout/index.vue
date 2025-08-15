<template>
  <div class="app-layout">
    <!-- 侧边栏 -->
    <div class="sidebar">
      <div class="logo">
        <h2>油墩港平台</h2>
      </div>
      <nav class="nav-menu">
        <router-link 
          v-for="item in menuItems" 
          :key="item.path"
          :to="item.path"
          class="nav-item"
          active-class="active"
        >
          <el-icon><component :is="item.icon" /></el-icon>
          <span>{{ item.title }}</span>
        </router-link>
      </nav>
    </div>

    <!-- 主内容区域 -->
    <div class="main-content">
      <header class="header">
        <h1>{{ currentPageTitle }}</h1>
      </header>
      <main class="content">
        <router-view />
      </main>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import { useRoute } from 'vue-router'
import { 
  Odometer, 
  Tools, 
  Bridge, 
  Crane, 
  Water, 
  Lightning, 
  Drone, 
  Truck, 
  Setting 
} from '@element-plus/icons-vue'

const route = useRoute()

const menuItems = ref([
  { path: '/dashboard', title: '仪表盘', icon: 'Odometer' },
  { path: '/test', title: '功能测试', icon: 'Tools' },
  { path: '/bridge', title: '桥梁监测', icon: 'Bridge' },
  { path: '/tower-crane', title: '塔吊监测', icon: 'Crane' },
  { path: '/water-quality', title: '水质监测', icon: 'Water' },
  { path: '/energy-consumption', title: '能耗监测', icon: 'Lightning' },
  { path: '/drone-inspection', title: '无人机巡检', icon: 'Drone' },
  { path: '/earthwork-flow', title: '土方流转', icon: 'Truck' },
  { path: '/system-settings', title: '系统设置', icon: 'Setting' }
])

const currentPageTitle = computed(() => {
  const currentItem = menuItems.value.find(item => item.path === route.path)
  return currentItem ? currentItem.title : '油墩港数字管理平台'
})
</script>

<style scoped>
.app-layout {
  display: flex;
  height: 100vh;
  background-color: #f5f5f5;
}

.sidebar {
  width: 250px;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: white;
  padding: 20px 0;
  box-shadow: 2px 0 10px rgba(0,0,0,0.1);
}

.logo {
  text-align: center;
  padding: 20px;
  border-bottom: 1px solid rgba(255,255,255,0.1);
  margin-bottom: 20px;
}

.logo h2 {
  margin: 0;
  color: white;
  font-size: 20px;
}

.nav-menu {
  padding: 0 20px;
}

.nav-item {
  display: flex;
  align-items: center;
  padding: 15px 20px;
  color: rgba(255,255,255,0.8);
  text-decoration: none;
  border-radius: 8px;
  margin-bottom: 8px;
  transition: all 0.3s ease;
}

.nav-item:hover {
  background-color: rgba(255,255,255,0.1);
  color: white;
  transform: translateX(5px);
}

.nav-item.active {
  background-color: rgba(255,255,255,0.2);
  color: white;
  font-weight: bold;
}

.nav-item .el-icon {
  margin-right: 12px;
  font-size: 18px;
}

.main-content {
  flex: 1;
  display: flex;
  flex-direction: column;
  overflow: hidden;
}

.header {
  background: white;
  padding: 20px 30px;
  border-bottom: 1px solid #e0e0e0;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

.header h1 {
  margin: 0;
  color: #333;
  font-size: 24px;
  font-weight: 600;
}

.content {
  flex: 1;
  padding: 30px;
  overflow-y: auto;
}
</style>

