import { defineStore } from 'pinia'
import { ref } from 'vue'

export interface UserInfo {
  id: number
  username: string
  nickname: string
  avatar?: string
  roles: string[]
  permissions: string[]
}

export const useUserStore = defineStore('user', () => {
  const token = ref<string>('')
  const userInfo = ref<UserInfo | null>(null)
  const isLogin = ref<boolean>(false)

  // 设置token
  const setToken = (newToken: string) => {
    token.value = newToken
    localStorage.setItem('token', newToken)
  }

  // 获取token
  const getToken = (): string => {
    if (!token.value) {
      token.value = localStorage.getItem('token') || ''
    }
    return token.value
  }

  // 设置用户信息
  const setUserInfo = (info: UserInfo) => {
    userInfo.value = info
    isLogin.value = true
  }

  // 清除用户信息
  const clearUserInfo = () => {
    token.value = ''
    userInfo.value = null
    isLogin.value = false
    localStorage.removeItem('token')
  }

  // 检查是否有权限
  const hasPermission = (permission: string): boolean => {
    if (!userInfo.value) return false
    return userInfo.value.permissions.includes(permission)
  }

  // 检查是否有角色
  const hasRole = (role: string): boolean => {
    if (!userInfo.value) return false
    return userInfo.value.roles.includes(role)
  }

  return {
    token,
    userInfo,
    isLogin,
    setToken,
    getToken,
    setUserInfo,
    clearUserInfo,
    hasPermission,
    hasRole
  }
})

