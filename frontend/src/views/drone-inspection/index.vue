<template>
  <div class="drone-inspection">
    <div class="page-header">
      <h2>无人机巡检</h2>
      <p>智能无人机自动巡检，提升港口安全管理效率</p>
    </div>

    <div class="monitoring-content">
      <div class="drone-status">
        <div class="status-card">
          <h3>巡检状态</h3>
          <div class="status-value">执行中</div>
          <div class="status-desc">正在进行第3号区域巡检</div>
        </div>
        <div class="status-card">
          <h3>电池电量</h3>
          <div class="status-value">78%</div>
          <div class="status-desc">预计剩余飞行时间: 25分钟</div>
        </div>
      </div>

      <div class="inspection-data">
        <h3>巡检数据</h3>
        <div class="data-grid">
          <div class="data-item">
            <span class="label">今日巡检次数:</span>
            <span class="value">12次</span>
          </div>
          <div class="data-item">
            <span class="label">巡检覆盖面积:</span>
            <span class="value">2.5平方公里</span>
          </div>
          <div class="data-item">
            <span class="label">发现异常:</span>
            <span class="value">3处</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
// 无人机巡检页面逻辑
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

.drone-status {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 24px;
}

.status-card {
  background: white;
  padding: 30px;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
  text-align: center;
}

.status-card h3 {
  margin: 0 0 16px 0;
  color: #333;
  font-size: 18px;
}

.status-value {
  font-size: 28px;
  font-weight: bold;
  color: #667eea;
  margin-bottom: 12px;
}

.status-desc {
  color: #666;
  font-size: 14px;
}

.inspection-data {
  background: white;
  padding: 30px;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}

.inspection-data h3 {
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

