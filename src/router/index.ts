import { createRouter, createWebHistory } from 'vue-router'
import type { RouteRecordRaw } from 'vue-router'

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    name: 'Layout',
    component: () => import('@/layout/index.vue'),
    redirect: '/dashboard',
    children: [
      {
        path: '/dashboard',
        name: 'Dashboard',
        component: () => import('@/views/dashboard/index.vue'),
        meta: { title: '仪表盘', icon: 'Odometer' }
      },
      {
        path: '/test',
        name: 'Test',
        component: () => import('@/views/test/index.vue'),
        meta: { title: '功能测试', icon: 'Tools' }
      },
      {
        path: '/bridge',
        name: 'Bridge',
        component: () => import('@/views/bridge/index.vue'),
        meta: { title: '桥梁监测', icon: 'Bridge' }
      },
      {
        path: '/tower-crane',
        name: 'TowerCrane',
        component: () => import('@/views/tower-crane/index.vue'),
        meta: { title: '塔吊监测', icon: 'Crane' }
      },
      {
        path: '/water-quality',
        name: 'WaterQuality',
        component: () => import('@/views/water-quality/index.vue'),
        meta: { title: '水质监测', icon: 'Water' }
      },
      {
        path: '/energy-consumption',
        name: 'EnergyConsumption',
        component: () => import('@/views/energy-consumption/index.vue'),
        meta: { title: '能耗监测', icon: 'Lightning' }
      },
      {
        path: '/drone-inspection',
        name: 'DroneInspection',
        component: () => import('@/views/drone-inspection/index.vue'),
        meta: { title: '无人机巡检', icon: 'Drone' }
      },
      {
        path: '/earthwork-flow',
        name: 'EarthworkFlow',
        component: () => import('@/views/earthwork-flow/index.vue'),
        meta: { title: '土方流转', icon: 'Truck' }
      },
      {
        path: '/system-settings',
        name: 'SystemSettings',
        component: () => import('@/views/system-settings/index.vue'),
        meta: { title: '系统设置', icon: 'Setting' }
      }
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/login/index.vue'),
    meta: { title: '登录' }
  },
  {
    path: '/:pathMatch(.*)*',
    name: 'NotFound',
    component: () => import('@/views/error/404.vue'),
    meta: { title: '404' }
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

// 路由守卫
router.beforeEach((to, from, next) => {
  // 设置页面标题
  document.title = to.meta.title ? `${to.meta.title} - 油墩港数字管理平台` : '油墩港数字管理平台'
  
  // 这里可以添加登录验证等逻辑
  next()
})

export default router
