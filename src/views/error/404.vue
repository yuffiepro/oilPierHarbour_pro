<template>
  <div class="error-page">
    <div class="error-content">
      <h1>404</h1>
      <h2>页面未找到</h2>
      <p>抱歉，您访问的页面不存在</p>
      <el-button type="primary" @click="goHome">返回首页</el-button>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goHome = () => {
  router.push('/')
}
</script>

<style scoped>
.error-page {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background: #f5f5f5;
}

.error-content {
  text-align: center;
  padding: 40px;
}

.error-content h1 {
  font-size: 120px;
  color: #667eea;
  margin: 0;
}

.error-content h2 {
  font-size: 32px;
  color: #333;
  margin: 20px 0;
}

.error-content p {
  font-size: 18px;
  color: #666;
  margin-bottom: 30px;
}
</style>

