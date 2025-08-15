<template>
  <div class="drone-inspection">
    <div class="page-header">
      <h2>无人机巡检</h2>
      <p>智能无人机自动巡检港口设施和安全隐患</p>
    </div>

    <div class="monitoring-content">
      <div class="status-cards">
        <div class="status-card">
          <div class="status-icon success">
            <el-icon><Check /></el-icon>
          </div>
          <div class="status-info">
            <h3>无人机状态</h3>
            <p class="status-text">在线运行</p>
          </div>
        </div>

        <div class="status-card">
          <div class="status-icon info">
            <el-icon><InfoFilled /></el-icon>
          </div>
          <div class="status-info">
            <h3>巡检进度</h3>
            <p class="status-text">75% 完成</p>
          </div>
        </div>

        <div class="status-card">
          <div class="status-icon warning">
            <el-icon><Warning /></el-icon>
          </div>
          <div class="status-info">
            <h3>发现异常</h3>
            <p class="status-text">2 处</p>
          </div>
        </div>
      </div>

      <div class="data-section">
        <h3>巡检数据</h3>
        <div class="data-grid">
          <div class="data-item">
            <span class="label">今日巡检:</span>
            <span class="value">8 次</span>
          </div>
          <div class="data-item">
            <span class="label">覆盖面积:</span>
            <span class="value">2.5 km²</span>
          </div>
          <div class="data-item">
            <span class="label">飞行时长:</span>
            <span class="value">4.2 小时</span>
          </div>
          <div class="data-item">
            <span class="label">拍摄照片:</span>
            <span class="value">156 张</span>
          </div>
          <div class="data-item">
            <span class="label">异常发现:</span>
            <span class="value">2 处</span>
          </div>
          <div class="data-item">
            <span class="label">电池电量:</span>
            <span class="value">85%</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { Check, Warning, InfoFilled } from '@element-plus/icons-vue'
</script>

<style scoped>
.drone-inspection {
  max-width: 1000px;
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

.monitoring-content {
  display: flex;
  flex-direction: column;
  gap: 30px;
}

.status-cards {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 24px;
}

.status-card {
  background: white;
  padding: 24px;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
  display: flex;
  align-items: center;
}

.status-icon {
  width: 60px;
  height: 60px;
  border-radius: 12px;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-right: 20px;
}

.status-icon.success {
  background: #67c23a;
}

.status-icon.warning {
  background: #e6a23c;
}

.status-icon.info {
  background: #409eff;
}

.status-icon .el-icon {
  font-size: 28px;
  color: white;
}

.status-info h3 {
  margin: 0 0 8px 0;
  color: #333;
  font-size: 18px;
}

.status-text {
  margin: 0;
  font-size: 16px;
  font-weight: bold;
}

.data-section {
  background: white;
  padding: 30px;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}

.data-section h3 {
  margin: 0 0 20px 0;
  color: #333;
  font-size: 20px;
}

.data-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 20px;
}

.data-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 16px;
  background: #f8f9fa;
  border-radius: 8px;
}

.data-item .label {
  color: #666;
  font-size: 14px;
}

.data-item .value {
  color: #333;
  font-size: 16px;
  font-weight: bold;
}
</style>
