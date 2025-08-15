# 油墩港数字管理平台 API 文档

## 概述

本文档描述了油墩港数字管理平台的后端API接口规范。

## 基础信息

- **基础URL**: `http://localhost:8080/api`
- **数据格式**: JSON
- **字符编码**: UTF-8
- **认证方式**: HTTP Basic Auth (开发阶段)

## 通用响应格式

所有API接口都使用统一的响应格式：

```json
{
  "code": 200,
  "message": "操作成功",
  "data": {},
  "timestamp": 1692081045000
}
```

### 响应字段说明

| 字段 | 类型 | 说明 |
|------|------|------|
| code | Integer | 响应状态码，200表示成功 |
| message | String | 响应消息 |
| data | Object/Array | 响应数据 |
| timestamp | Long | 响应时间戳 |

### 状态码说明

| 状态码 | 说明 |
|--------|------|
| 200 | 请求成功 |
| 400 | 请求参数错误 |
| 401 | 未授权访问 |
| 403 | 禁止访问 |
| 404 | 资源不存在 |
| 500 | 服务器内部错误 |

## 桥梁监测接口

### 1. 获取最新监测数据

**接口地址**: `GET /bridge/monitoring/{pointId}`

**请求参数**:
- `pointId` (路径参数): 监测点ID

**响应示例**:
```json
{
  "code": 200,
  "message": "操作成功",
  "data": {
    "id": 1,
    "pointId": "B-P001",
    "verticalDispl": 2.15,
    "lateralDispl": 0.85,
    "temperature": 25.5,
    "windSpeed": 2.8,
    "status": 0,
    "cableForce": 850.0,
    "stressValue": 150.0,
    "deviation": 0.5,
    "createTime": "2023-08-15T14:30:45",
    "updateTime": "2023-08-15T14:30:45"
  },
  "timestamp": 1692081045000
}
```

### 2. 获取历史监测数据

**接口地址**: `GET /bridge/monitoring/{pointId}/history`

**请求参数**:
- `pointId` (路径参数): 监测点ID
- `limit` (查询参数): 限制条数，默认100

**响应示例**:
```json
{
  "code": 200,
  "message": "操作成功",
  "data": [
    {
      "id": 1,
      "pointId": "B-P001",
      "verticalDispl": 2.15,
      "lateralDispl": 0.85,
      "temperature": 25.5,
      "windSpeed": 2.8,
      "status": 0,
      "createTime": "2023-08-15T14:30:45"
    }
  ],
  "timestamp": 1692081045000
}
```

### 3. 获取预警监测点

**接口地址**: `GET /bridge/monitoring/warning`

**响应示例**:
```json
{
  "code": 200,
  "message": "操作成功",
  "data": [
    {
      "id": 2,
      "pointId": "B-P002",
      "verticalDispl": 3.25,
      "lateralDispl": 1.08,
      "temperature": 28.5,
      "windSpeed": 3.2,
      "status": 1,
      "createTime": "2023-08-15T14:30:45"
    }
  ],
  "timestamp": 1692081045000
}
```

### 4. 保存监测数据

**接口地址**: `POST /bridge/monitoring`

**请求体**:
```json
{
  "pointId": "B-P001",
  "verticalDispl": 2.15,
  "lateralDispl": 0.85,
  "temperature": 25.5,
  "windSpeed": 2.8,
  "cableForce": 850.0,
  "stressValue": 150.0,
  "deviation": 0.5
}
```

**响应示例**:
```json
{
  "code": 200,
  "message": "操作成功",
  "data": true,
  "timestamp": 1692081045000
}
```

## 土方流转接口

### 1. 录入土方数据

**接口地址**: `POST /earthwork/record`

**请求体**:
```json
{
  "sectionId": "SEC-001",
  "excavation": 1250.75,
  "backfill": 850.25,
  "transportOut": 400.50,
  "transportIn": 320.25,
  "recordDate": "2023-08-15",
  "earthworkType": 1,
  "disposalMethod": 1,
  "transportDistance": 5.20
}
```

**响应示例**:
```json
{
  "code": 200,
  "message": "操作成功",
  "data": true,
  "timestamp": 1692081045000
}
```

### 2. 查询土方数据

**接口地址**: `GET /earthwork/query`

**请求参数**:
- `sectionId` (查询参数): 标段ID
- `startDate` (查询参数): 开始日期
- `endDate` (查询参数): 结束日期

**响应示例**:
```json
{
  "code": 200,
  "message": "操作成功",
  "data": [
    {
      "id": 1,
      "sectionId": "SEC-001",
      "excavation": 1250.75,
      "backfill": 850.25,
      "transportOut": 400.50,
      "transportIn": 320.25,
      "carbonValue": 15.5,
      "recordDate": "2023-08-15"
    }
  ],
  "timestamp": 1692081045000
}
```

## 塔吊监测接口

### 1. 获取塔吊状态

**接口地址**: `GET /tower-crane/status/{craneId}`

**请求参数**:
- `craneId` (路径参数): 塔吊ID

**响应示例**:
```json
{
  "code": 200,
  "message": "操作成功",
  "data": {
    "id": 1,
    "craneId": "TC-001",
    "tiltAngle": 0.85,
    "stress": 120.5,
    "loadWeight": 8.5,
    "workRadius": 45.2,
    "windSpeed": 3.2,
    "alarmStatus": 0,
    "craneHeight": 85.5,
    "armAngle": 45.8,
    "hookHeight": 65.3,
    "updateTime": "2023-08-15T14:30:45"
  },
  "timestamp": 1692081045000
}
```

## 错误处理

### 参数验证错误

```json
{
  "code": 400,
  "message": "参数验证失败",
  "data": {
    "field": "pointId",
    "message": "监测点ID不能为空"
  },
  "timestamp": 1692081045000
}
```

### 服务器错误

```json
{
  "code": 500,
  "message": "服务器内部错误",
  "data": null,
  "timestamp": 1692081045000
}
```

## 分页查询

支持分页的接口使用以下参数：

- `page`: 页码，从1开始
- `size`: 每页大小，默认20
- `sort`: 排序字段，格式：`字段名,排序方向`
  - 示例：`sort=createTime,desc`

**分页响应格式**:
```json
{
  "code": 200,
  "message": "操作成功",
  "data": {
    "records": [],
    "total": 100,
    "size": 20,
    "current": 1,
    "pages": 5
  },
  "timestamp": 1692081045000
}
```

## 实时数据推送

系统支持通过WebSocket推送实时数据：

**WebSocket连接地址**: `ws://localhost:8080/ws`

**订阅主题**:
- `/topic/bridge/monitoring` - 桥梁监测数据
- `/topic/tower-crane/status` - 塔吊状态数据
- `/topic/earthwork/flow` - 土方流转数据

**消息格式**:
```json
{
  "type": "BRIDGE_MONITORING",
  "data": {
    "pointId": "B-P001",
    "verticalDispl": 2.15,
    "status": 0
  },
  "timestamp": 1692081045000
}
```

## 认证与授权

### 开发阶段

使用HTTP Basic认证：

```bash
curl -u username:password http://localhost:8080/api/bridge/monitoring/B-P001
```

### 生产阶段

将实现JWT Token认证，具体实现方式待定。

## 限流策略

- 普通接口：100次/分钟
- 数据查询接口：1000次/分钟
- 数据写入接口：50次/分钟

## 版本控制

当前API版本：v1.0

后续版本更新将通过URL路径区分：
- v1.0: `/api/v1/...`
- v2.0: `/api/v2/...`

## 联系信息

如有问题，请联系开发团队。
