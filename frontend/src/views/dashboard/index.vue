<template>
  <div class="dashboard">
    <div class="welcome-section">
      <h2>欢迎使用油墩港数字管理平台</h2>
      <p>这是一个综合性的港口管理平台，提供全方位的监测和管理功能</p>
    </div>

    <div class="stats-grid">
      <div class="stat-card">
        <div class="stat-icon">
          <el-icon><Bridge /></el-icon>
        </div>
        <div class="stat-content">
          <h3>桥梁监测</h3>
          <p>实时监控桥梁结构安全</p>
        </div>
      </div>

      <div class="stat-card">
        <div class="stat-icon">
          <el-icon><Crane /></el-icon>
        </div>
        <div class="stat-content">
          <h3>塔吊监控</h3>
          <p>智能监控塔吊运行状态</p>
        </div>
      </div>

      <div class="stat-card">
        <div class="stat-icon">
          <el-icon><Water /></el-icon>
        </div>
        <div class="stat-content">
          <h3>水质监测</h3>
          <p>持续监测港口水质状况</p>
        </div>
      </div>

      <div class="stat-card">
        <div class="stat-icon">
          <el-icon><Lightning /></el-icon>
        </div>
        <div class="stat-content">
          <h3>能耗管理</h3>
          <p>优化港口能源使用效率</p>
        </div>
      </div>
    </div>

    <div class="quick-actions">
      <h3>快速操作</h3>
      <div class="action-buttons">
        <el-button type="primary" @click="goToTest">功能测试</el-button>
        <el-button type="success" @click="goToBridge">桥梁监测</el-button>
        <el-button type="warning" @click="goToTowerCrane">塔吊监控</el-button>
        <el-button type="info" @click="goToWaterQuality">水质监测</el-button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { Bridge, Crane, Water, Lightning } from '@element-plus/icons-vue'
import { useRouter } from 'vue-router'

const router = useRouter()

const goToTest = () => router.push('/test')
const goToBridge = () => router.push('/bridge')
const goToTowerCrane = () => router.push('/tower-crane')
const goToWaterQuality = () => router.push('/water-quality')
</script>

<style scoped>
.dashboard {
  max-width: 1200px;
  margin: 0 auto;
}

.welcome-section {
  text-align: center;
  margin-bottom: 40px;
  padding: 40px;
  background: white;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}

.welcome-section h2 {
  color: #333;
  margin-bottom: 16px;
  font-size: 28px;
}

.welcome-section p {
  color: #666;
  font-size: 16px;
  margin: 0;
}

.stats-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
  gap: 24px;
  margin-bottom: 40px;
}

.stat-card {
  background: white;
  padding: 24px;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
  display: flex;
  align-items: center;
  transition: transform 0.3s ease;
}

.stat-card:hover {
  transform: translateY(-5px);
}

.stat-icon {
  width: 60px;
  height: 60px;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  border-radius: 12px;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-right: 20px;
}

.stat-icon .el-icon {
  font-size: 28px;
  color: white;
}

.stat-content h3 {
  margin: 0 0 8px 0;
  color: #333;
  font-size: 18px;
}

.stat-content p {
  margin: 0;
  color: #666;
  font-size: 14px;
}

.quick-actions {
  background: white;
  padding: 30px;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}

.quick-actions h3 {
  margin: 0 0 20px 0;
  color: #333;
  font-size: 20px;
}

.action-buttons {
  display: flex;
  gap: 16px;
  flex-wrap: wrap;
}

.action-buttons .el-button {
  min-width: 120px;
}
</style>

