<template>
  <div class="tower-crane-monitoring">
    <div class="page-header">
      <h2>塔吊监测</h2>
      <p>智能监控塔吊运行状态和安全参数</p>
    </div>

    <div class="monitoring-content">
      <div class="crane-status">
        <div class="status-overview">
          <div class="status-item">
            <span class="label">运行状态:</span>
            <span class="value running">运行中</span>
          </div>
          <div class="status-item">
            <span class="label">工作模式:</span>
            <span class="value">自动模式</span>
          </div>
          <div class="status-item">
            <span class="label">安全等级:</span>
            <span class="value safe">A级</span>
          </div>
        </div>
      </div>

      <div class="data-cards">
        <div class="data-card">
          <h3>角度监测</h3>
          <div class="data-value">45.2°</div>
          <div class="data-unit">当前角度</div>
        </div>

        <div class="data-card">
          <h3>高度监测</h3>
          <div class="data-value">28.5m</div>
          <div class="data-unit">当前高度</div>
        </div>

        <div class="data-card">
          <h3>载重监测</h3>
          <div class="data-value">2.8t</div>
          <div class="data-unit">当前载重</div>
        </div>

        <div class="data-card">
          <h3>风速监测</h3>
          <div class="data-value">3.2m/s</div>
          <div class="data-unit">当前风速</div>
        </div>
      </div>

      <div class="alert-section">
        <h3>安全预警</h3>
        <div class="alert-list">
          <div class="alert-item warning">
            <el-icon><Warning /></el-icon>
            <span>风速接近安全阈值，请注意操作</span>
          </div>
          <div class="alert-item info">
            <el-icon><InfoFilled /></el-icon>
            <span>设备运行时间：8小时32分钟</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { Warning, InfoFilled } from '@element-plus/icons-vue'
</script>

<style scoped>
.tower-crane-monitoring {
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

.crane-status {
  background: white;
  padding: 30px;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}

.status-overview {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 20px;
}

.status-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 16px;
  background: #f8f9fa;
  border-radius: 8px;
}

.status-item .label {
  color: #666;
  font-size: 14px;
}

.status-item .value {
  font-size: 16px;
  font-weight: bold;
}

.value.running {
  color: #67c23a;
}

.value.safe {
  color: #409eff;
}

.data-cards {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
  gap: 24px;
}

.data-card {
  background: white;
  padding: 24px;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
  text-align: center;
}

.data-card h3 {
  margin: 0 0 16px 0;
  color: #333;
  font-size: 16px;
}

.data-value {
  font-size: 32px;
  font-weight: bold;
  color: #667eea;
  margin-bottom: 8px;
}

.data-unit {
  color: #666;
  font-size: 14px;
}

.alert-section {
  background: white;
  padding: 30px;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}

.alert-section h3 {
  margin: 0 0 20px 0;
  color: #333;
  font-size: 20px;
}

.alert-list {
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.alert-item {
  display: flex;
  align-items: center;
  padding: 16px;
  border-radius: 8px;
  gap: 12px;
}

.alert-item.warning {
  background: #fdf6ec;
  color: #e6a23c;
  border-left: 4px solid #e6a23c;
}

.alert-item.info {
  background: #f0f9ff;
  color: #409eff;
  border-left: 4px solid #409eff;
}

.alert-item .el-icon {
  font-size: 18px;
}
</style>

