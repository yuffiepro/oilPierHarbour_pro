<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script setup lang="ts">
// 使用路由系统，不需要额外的逻辑
</script>

<style>
#app {
  height: 100vh;
  width: 100vw;
  margin: 0;
  padding: 0;
}

/* 全局样式重置 */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei', 'Helvetica Neue', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
</style>
