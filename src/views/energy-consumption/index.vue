<template>
  <div class="energy-consumption-monitoring">
    <div class="page-header">
      <h2>能耗监测</h2>
      <p>实时监控港口能源使用情况和效率分析</p>
    </div>

    <div class="monitoring-content">
      <div class="status-cards">
        <div class="status-card">
          <div class="status-icon success">
            <el-icon><Check /></el-icon>
          </div>
          <div class="status-info">
            <h3>电力消耗</h3>
            <p class="status-text">85% 效率</p>
          </div>
        </div>

        <div class="status-card">
          <div class="status-icon warning">
            <el-icon><Warning /></el-icon>
          </div>
          <div class="status-info">
            <h3>燃油消耗</h3>
            <p class="status-text">92% 效率</p>
          </div>
        </div>

        <div class="status-card">
          <div class="status-icon info">
            <el-icon><InfoFilled /></el-icon>
          </div>
          <div class="status-info">
            <h3>水资源</h3>
            <p class="status-text">78% 效率</p>
          </div>
        </div>
      </div>

      <div class="data-section">
        <h3>能耗监测数据</h3>
        <div class="data-grid">
          <div class="data-item">
            <span class="label">今日用电量:</span>
            <span class="value">2,450 kWh</span>
          </div>
          <div class="data-item">
            <span class="label">燃油消耗:</span>
            <span class="value">180 L</span>
          </div>
          <div class="data-item">
            <span class="label">用水量:</span>
            <span class="value">85 m³</span>
          </div>
          <div class="data-item">
            <span class="label">碳排放:</span>
            <span class="value">2.1 吨</span>
          </div>
          <div class="data-item">
            <span class="label">节能率:</span>
            <span class="value">15.2%</span>
          </div>
          <div class="data-item">
            <span class="label">成本节约:</span>
            <span class="value">¥8,500</span>
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
.energy-consumption-monitoring {
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
