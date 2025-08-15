<template>
  <div class="earthwork-flow">
    <div class="page-header">
      <h2>土方流转</h2>
      <p>智能管理港口土方运输和流转过程</p>
    </div>

    <div class="monitoring-content">
      <div class="flow-overview">
        <div class="flow-card">
          <h3>今日运输量</h3>
          <div class="flow-value">1,250 m³</div>
          <div class="flow-trend positive">+12.5%</div>
        </div>
        <div class="flow-card">
          <h3>运输车辆</h3>
          <div class="flow-value">18辆</div>
          <div class="flow-trend neutral">0%</div>
        </div>
        <div class="flow-card">
          <h3>完成率</h3>
          <div class="flow-value">85.2%</div>
          <div class="flow-trend positive">+3.2%</div>
        </div>
      </div>

      <div class="flow-data">
        <h3>流转数据</h3>
        <div class="data-grid">
          <div class="data-item">
            <span class="label">起点位置:</span>
            <span class="value">A区码头</span>
          </div>
          <div class="data-item">
            <span class="label">终点位置:</span>
            <span class="value">B区堆场</span>
          </div>
          <div class="data-item">
            <span class="label">运输距离:</span>
            <span class="value">2.8公里</span>
          </div>
          <div class="data-item">
            <span class="label">预计时间:</span>
            <span class="value">45分钟</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
// 土方流转页面逻辑
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

.flow-overview {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 24px;
}

.flow-card {
  background: white;
  padding: 30px;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
  text-align: center;
}

.flow-card h3 {
  margin: 0 0 16px 0;
  color: #333;
  font-size: 18px;
}

.flow-value {
  font-size: 28px;
  font-weight: bold;
  color: #667eea;
  margin-bottom: 12px;
}

.flow-trend {
  font-size: 16px;
  font-weight: bold;
}

.flow-trend.positive {
  color: #67c23a;
}

.flow-trend.negative {
  color: #f56c6c;
}

.flow-trend.neutral {
  color: #909399;
}

.flow-data {
  background: white;
  padding: 30px;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}

.flow-data h3 {
  margin: 0 0 24px 0;
  color: #333;
  font-size: 20px;
}

.data-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 20px;
}

.data-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 20px;
  background: #f8f9fa;
  border-radius: 8px;
}

.data-item .label {
  color: #666;
  font-size: 14px;
}

.data-item .value {
  color: #333;
  font-size: 18px;
  font-weight: bold;
}
</style>

