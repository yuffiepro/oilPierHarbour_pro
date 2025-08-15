<template>
  <div class="test-page">
    <h1>油墩港数字管理平台 - 功能测试</h1>
    <div class="test-section">
      <h3>认证测试</h3>
      <el-button @click="testLogin" type="primary">测试登录</el-button>
      <div v-if="loginResult">{{ loginResult }}</div>
    </div>
    <div class="test-section">
      <h3>API测试</h3>
      <el-button @click="testHealth" type="success">健康检查</el-button>
      <div v-if="apiResult">{{ apiResult }}</div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'

const loginResult = ref('')
const apiResult = ref('')

const testLogin = async () => {
  try {
    const response = await axios.post('/api/auth/login', {
      username: 'admin',
      password: '123456'
    })
    loginResult.value = JSON.stringify(response.data, null, 2)
  } catch (error) {
    loginResult.value = '登录失败: ' + error.message
  }
}

const testHealth = async () => {
  try {
    const response = await axios.get('/api/test/health')
    apiResult.value = JSON.stringify(response.data, null, 2)
  } catch (error) {
    apiResult.value = '健康检查失败: ' + error.message
  }
}
</script>

<style scoped>
.test-page {
  padding: 20px;
  max-width: 800px;
  margin: 0 auto;
}
.test-section {
  margin-bottom: 20px;
  padding: 15px;
  border: 1px solid #eee;
  border-radius: 8px;
}
pre {
  background-color: #f5f5f5;
  padding: 10px;
  border-radius: 4px;
  overflow-x: auto;
}
</style>
