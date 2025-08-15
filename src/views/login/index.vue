<template>
  <div class="login-page">
    <div class="login-container">
      <div class="login-header">
        <h1>油墩港数字管理平台</h1>
        <p>请登录您的账户</p>
      </div>
      <div class="login-form">
        <el-form>
          <el-form-item>
            <el-input v-model="username" placeholder="用户名" prefix-icon="User" />
          </el-form-item>
          <el-form-item>
            <el-input v-model="password" type="password" placeholder="密码" prefix-icon="Lock" />
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="handleLogin" style="width: 100%">登录</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const username = ref('admin')
const password = ref('123456')

const handleLogin = () => {
  // 简单的登录逻辑
  if (username.value === 'admin' && password.value === '123456') {
    router.push('/dashboard')
  }
}
</script>

<style scoped>
.login-page {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
}

.login-container {
  background: white;
  padding: 40px;
  border-radius: 12px;
  box-shadow: 0 10px 30px rgba(0,0,0,0.2);
  width: 400px;
}

.login-header {
  text-align: center;
  margin-bottom: 30px;
}

.login-header h1 {
  color: #333;
  margin-bottom: 10px;
}

.login-header p {
  color: #666;
  margin: 0;
}

.login-form {
  margin-top: 20px;
}
</style>

