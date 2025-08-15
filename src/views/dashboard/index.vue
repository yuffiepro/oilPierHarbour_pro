<template>
  <div class="dashboard">
    <!-- 统计卡片 -->
    <div class="stat-cards">
      <el-row :gutter="20">
        <el-col :span="6" v-for="stat in statCards" :key="stat.title">
          <el-card class="stat-card" :class="stat.type">
            <div class="stat-content">
              <div class="stat-icon">
                <el-icon><component :is="stat.icon" /></el-icon>
              </div>
              <div class="stat-info">
                <div class="stat-value">{{ stat.value }}</div>
                <div class="stat-title">{{ stat.title }}</div>
              </div>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </div>

    <!-- 图表区域 -->
    <div class="charts-container">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-card class="chart-card">
            <template #header>
              <span>桥梁监测数据趋势</span>
            </template>
            <div class="chart" ref="bridgeChartRef"></div>
          </el-card>
        </el-col>
        <el-col :span="12">
          <el-card class="chart-card">
            <template #header>
              <span>土方流转统计</span>
            </template>
            <div class="chart" ref="earthworkChartRef"></div>
          </el-card>
        </el-col>
      </el-row>
    </div>

    <!-- 实时监控 -->
    <div class="monitoring-section">
      <el-card class="monitoring-card">
        <template #header>
          <span>实时监控状态</span>
        </template>
        <el-table :data="monitoringData" style="width: 100%">
          <el-table-column prop="name" label="监测项目" />
          <el-table-column prop="status" label="状态">
            <template #default="{ row }">
              <el-tag :type="row.status === '正常' ? 'success' : 'danger'">
                {{ row.status }}
              </el-tag>
            </template>
          </el-table-column>
          <el-table-column prop="lastUpdate" label="最后更新" />
          <el-table-column prop="value" label="当前值" />
        </el-table>
      </el-card>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted, onUnmounted } from 'vue'
import * as echarts from 'echarts'

// 统计卡片数据
const statCards = ref([
  {
    title: '监测点总数',
    value: '24',
    icon: 'Location',
    type: 'primary'
  },
  {
    title: '预警数量',
    value: '3',
    icon: 'Warning',
    type: 'warning'
  },
  {
    title: '今日土方量',
    value: '1,250 m³',
    icon: 'Truck',
    type: 'success'
  },
  {
    title: '系统运行时间',
    value: '15天',
    icon: 'Timer',
    type: 'info'
  }
])

// 监控数据
const monitoringData = ref([
  {
    name: '桥梁监测点B-P001',
    status: '正常',
    lastUpdate: '2023-08-15 14:30:45',
    value: '竖向位移: 2.15mm'
  },
  {
    name: '塔吊TC-002',
    status: '预警',
    lastUpdate: '2023-08-15 14:29:30',
    value: '倾斜角度: 1.20°'
  },
  {
    name: '水质监测点WQ-001',
    status: '正常',
    lastUpdate: '2023-08-15 14:28:15',
    value: 'pH值: 7.2'
  }
])

// 图表引用
const bridgeChartRef = ref<HTMLElement>()
const earthworkChartRef = ref<HTMLElement>()

// 图表实例
let bridgeChart: echarts.ECharts | null = null
let earthworkChart: echarts.ECharts | null = null

// 初始化桥梁监测图表
const initBridgeChart = () => {
  if (!bridgeChartRef.value) return
  
  bridgeChart = echarts.init(bridgeChartRef.value)
  const option = {
    tooltip: {
      trigger: 'axis'
    },
    legend: {
      data: ['竖向位移', '横向位移', '温度']
    },
    xAxis: {
      type: 'category',
      data: ['00:00', '04:00', '08:00', '12:00', '16:00', '20:00']
    },
    yAxis: {
      type: 'value'
    },
    series: [
      {
        name: '竖向位移',
        type: 'line',
        data: [2.1, 2.3, 2.8, 3.2, 2.9, 2.5]
      },
      {
        name: '横向位移',
        type: 'line',
        data: [0.8, 0.9, 1.1, 1.3, 1.0, 0.8]
      },
      {
        name: '温度',
        type: 'line',
        data: [24, 25, 28, 30, 29, 26]
      }
    ]
  }
  bridgeChart.setOption(option)
}

// 初始化土方流转图表
const initEarthworkChart = () => {
  if (!earthworkChartRef.value) return
  
  earthworkChart = echarts.init(earthworkChartRef.value)
  const option = {
    tooltip: {
      trigger: 'item'
    },
    legend: {
      orient: 'vertical',
      left: 'left'
    },
    series: [
      {
        name: '土方处理',
        type: 'pie',
        radius: '50%',
        data: [
          { value: 850, name: '回填利用' },
          { value: 400, name: '外运处理' },
          { value: 320, name: '内部流转' }
        ],
        emphasis: {
          itemStyle: {
            shadowBlur: 10,
            shadowOffsetX: 0,
            shadowColor: 'rgba(0, 0, 0, 0.5)'
          }
        }
      }
    ]
  }
  earthworkChart.setOption(option)
}

// 监听窗口大小变化
const handleResize = () => {
  bridgeChart?.resize()
  earthworkChart?.resize()
}

onMounted(() => {
  initBridgeChart()
  initEarthworkChart()
  window.addEventListener('resize', handleResize)
})

onUnmounted(() => {
  window.removeEventListener('resize', handleResize)
  bridgeChart?.dispose()
  earthworkChart?.dispose()
})
</script>

<style lang="scss" scoped>
.dashboard {
  .stat-cards {
    margin-bottom: 20px;
    
    .stat-card {
      .stat-content {
        display: flex;
        align-items: center;
        
        .stat-icon {
          font-size: 48px;
          margin-right: 16px;
          
          &.primary { color: #409eff; }
          &.warning { color: #e6a23c; }
          &.success { color: #67c23a; }
          &.info { color: #909399; }
        }
        
        .stat-info {
          .stat-value {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 4px;
          }
          
          .stat-title {
            color: #666;
            font-size: 14px;
          }
        }
      }
    }
  }
  
  .charts-container {
    margin-bottom: 20px;
    
    .chart-card {
      .chart {
        height: 300px;
      }
    }
  }
  
  .monitoring-section {
    .monitoring-card {
      .el-table {
        margin-top: 16px;
      }
    }
  }
}
</style>
