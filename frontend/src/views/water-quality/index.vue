<template>
  <div class="water-quality-monitoring">
    <div class="page-header">
      <h2>水质监测</h2>
      <p>持续监测港口水质状况和环境参数</p>
    </div>

    <div class="monitoring-content">
      <div class="quality-overview">
        <div class="quality-card excellent">
          <div class="quality-icon">
            <el-icon><Check /></el-icon>
          </div>
          <div class="quality-info">
            <h3>水质等级</h3>
            <div class="quality-value">优秀</div>
            <div class="quality-score">95分</div>
          </div>
        </div>

        <div class="quality-card good">
          <div class="quality-icon">
            <el-icon><InfoFilled /></el-icon>
          </div>
          <div class="quality-info">
            <h3>监测点</h3>
            <div class="quality-value">12个</div>
            <div class="quality-score">全部正常</div>
          </div>
        </div>
      </div>

      <div class="parameters-section">
        <h3>关键参数监测</h3>
        <div class="parameters-grid">
          <div class="parameter-item">
            <div class="parameter-header">
              <span class="parameter-name">pH值</span>
              <span class="parameter-status normal">正常</span>
            </div>
            <div class="parameter-value">7.2</div>
            <div class="parameter-range">标准范围: 6.5-8.5</div>
          </div>

          <div class="parameter-item">
            <div class="parameter-header">
              <span class="parameter-name">溶解氧</span>
              <span class="parameter-status normal">正常</span>
            </div>
            <div class="parameter-value">8.5 mg/L</div>
            <div class="parameter-range">标准范围: ≥6.0 mg/L</div>
          </div>

          <div class="parameter-item">
            <div class="parameter-header">
              <span class="parameter-name">浊度</span>
              <span class="parameter-status warning">注意</span>
            </div>
            <div class="parameter-value">12 NTU</div>
            <div class="parameter-range">标准范围: ≤10 NTU</div>
          </div>

          <div class="parameter-item">
            <div class="parameter-header">
              <span class="parameter-name">温度</span>
              <span class="parameter-status normal">正常</span>
            </div>
            <div class="parameter-value">22°C</div>
            <div class="parameter-range">标准范围: 15-30°C</div>
          </div>
        </div>
      </div>

      <div class="trend-section">
        <h3>监测趋势</h3>
        <div class="trend-info">
          <div class="trend-item">
            <span class="trend-label">24小时变化:</span>
            <span class="trend-value positive">+2.1%</span>
          </div>
          <div class="trend-item">
            <span class="trend-label">本周趋势:</span>
            <span class="trend-value positive">+5.3%</span>
          </div>
          <div class="trend-item">
            <span class="trend-label">本月趋势:</span>
            <span class="trend-value negative">-1.2%</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { Check, InfoFilled } from '@element-plus/icons-vue'
</script>

<style scoped>
.water-quality-monitoring {
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

.quality-overview {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 24px;
}

.quality-card {
  background: white;
  padding: 30px;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
  display: flex;
  align-items: center;
}

.quality-card.excellent {
  border-left: 6px solid #67c23a;
}

.quality-card.good {
  border-left: 6px solid #409eff;
}

.quality-icon {
  width: 80px;
  height: 80px;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-right: 24px;
}

.quality-card.excellent .quality-icon {
  background: #67c23a;
}

.quality-card.good .quality-icon {
  background: #409eff;
}

.quality-icon .el-icon {
  font-size: 36px;
  color: white;
}

.quality-info h3 {
  margin: 0 0 12px 0;
  color: #333;
  font-size: 18px;
}

.quality-value {
  font-size: 24px;
  font-weight: bold;
  color: #333;
  margin-bottom: 8px;
}

.quality-score {
  color: #666;
  font-size: 14px;
}

.parameters-section {
  background: white;
  padding: 30px;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}

.parameters-section h3 {
  margin: 0 0 24px 0;
  color: #333;
  font-size: 20px;
}

.parameters-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(240px, 1fr));
  gap: 20px;
}

.parameter-item {
  padding: 20px;
  background: #f8f9fa;
  border-radius: 8px;
  border-left: 4px solid #ddd;
}

.parameter-item .parameter-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 12px;
}

.parameter-name {
  font-weight: bold;
  color: #333;
}

.parameter-status {
  padding: 4px 8px;
  border-radius: 4px;
  font-size: 12px;
  font-weight: bold;
}

.parameter-status.normal {
  background: #f0f9ff;
  color: #409eff;
}

.parameter-status.warning {
  background: #fdf6ec;
  color: #e6a23c;
}

.parameter-value {
  font-size: 24px;
  font-weight: bold;
  color: #667eea;
  margin-bottom: 8px;
}

.parameter-range {
  font-size: 12px;
  color: #666;
}

.trend-section {
  background: white;
  padding: 30px;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}

.trend-section h3 {
  margin: 0 0 20px 0;
  color: #333;
  font-size: 20px;
}

.trend-info {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 20px;
}

.trend-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 16px;
  background: #f8f9fa;
  border-radius: 8px;
}

.trend-label {
  color: #666;
  font-size: 14px;
}

.trend-value {
  font-weight: bold;
  font-size: 16px;
}

.trend-value.positive {
  color: #67c23a;
}

.trend-value.negative {
  color: #f56c6c;
}
</style>

