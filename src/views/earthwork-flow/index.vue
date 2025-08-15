<template>
  <div class="earthwork-flow">
    <div class="page-header">
      <h2>土方流转</h2>
      <p>监控土方运输、处理和利用的完整流程</p>
    </div>

    <div class="monitoring-content">
      <div class="status-cards">
        <div class="status-card">
          <div class="status-icon success">
            <el-icon><Check /></el-icon>
          </div>
          <div class="status-info">
            <h3>运输状态</h3>
            <p class="status-text">正常进行</p>
          </div>
        </div>

        <div class="status-card">
          <div class="status-icon info">
            <el-icon><InfoFilled /></el-icon>
          </div>
          <div class="status-info">
            <h3>处理进度</h3>
            <p class="status-text">68% 完成</p>
          </div>
        </div>

        <div class="status-card">
          <div class="status-icon warning">
            <el-icon><Warning /></el-icon>
          </div>
          <div class="status-info">
            <h3>库存预警</h3>
            <p class="status-text">库存不足</p>
          </div>
        </div>
      </div>

      <div class="data-section">
        <h3>土方流转数据</h3>
        <div class="data-grid">
          <div class="data-item">
            <span class="label">今日运输量:</span>
            <span class="value">1,250 m³</span>
          </div>
          <div class="data-item">
            <span class="label">处理量:</span>
            <span class="value">850 m³</span>
          </div>
          <div class="data-item">
            <span class="label">库存量:</span>
            <span class="value">320 m³</span>
          </div>
          <div class="data-item">
            <span class="label">运输车辆:</span>
            <span class="value">12 辆</span>
          </div>
          <div class="data-item">
            <span class="label">处理效率:</span>
            <span class="value">92%</span>
          </div>
          <div class="data-item">
            <span class="label">成本控制:</span>
            <span class="value">¥15,800</span>
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
.earthwork-flow {
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
