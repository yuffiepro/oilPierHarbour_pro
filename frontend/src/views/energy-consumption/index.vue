<template>
  <div class="energy-consumption">
    <div class="page-header">
      <h2>能耗监测</h2>
      <p>优化港口能源使用效率，实现绿色港口建设</p>
    </div>

    <div class="monitoring-content">
      <div class="energy-overview">
        <div class="energy-card">
          <h3>今日用电量</h3>
          <div class="energy-value">2,456 kWh</div>
          <div class="energy-trend positive">+5.2%</div>
        </div>
        <div class="energy-card">
          <h3>本月用电量</h3>
          <div class="energy-value">68,432 kWh</div>
          <div class="energy-trend negative">-2.1%</div>
        </div>
        <div class="energy-card">
          <h3>年度用电量</h3>
          <div class="energy-value">789,456 kWh</div>
          <div class="energy-trend positive">+8.5%</div>
        </div>
      </div>

      <div class="efficiency-section">
        <h3>能效指标</h3>
        <div class="efficiency-grid">
          <div class="efficiency-item">
            <span class="label">综合能效:</span>
            <span class="value">92.5%</span>
          </div>
          <div class="efficiency-item">
            <span class="label">设备利用率:</span>
            <span class="value">87.3%</span>
          </div>
          <div class="efficiency-item">
            <span class="label">节能率:</span>
            <span class="value">15.2%</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
// 能耗监测页面逻辑
</script>

<style scoped>
.energy-consumption {
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

.energy-overview {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 24px;
}

.energy-card {
  background: white;
  padding: 30px;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
  text-align: center;
}

.energy-card h3 {
  margin: 0 0 16px 0;
  color: #333;
  font-size: 18px;
}

.energy-value {
  font-size: 28px;
  font-weight: bold;
  color: #667eea;
  margin-bottom: 12px;
}

.energy-trend {
  font-size: 16px;
  font-weight: bold;
}

.energy-trend.positive {
  color: #67c23a;
}

.energy-trend.negative {
  color: #f56c6c;
}

.efficiency-section {
  background: white;
  padding: 30px;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}

.efficiency-section h3 {
  margin: 0 0 24px 0;
  color: #333;
  font-size: 20px;
}

.efficiency-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 20px;
}

.efficiency-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 20px;
  background: #f8f9fa;
  border-radius: 8px;
}

.efficiency-item .label {
  color: #666;
  font-size: 14px;
}

.efficiency-item .value {
  color: #333;
  font-size: 18px;
  font-weight: bold;
}
</style>

