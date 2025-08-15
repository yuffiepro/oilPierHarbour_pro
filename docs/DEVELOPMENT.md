# 油墩港数字管理平台开发指南

## 🚀 快速开始

### 环境要求
- Java 8+
- Node.js 16+
- MySQL 8.0+
- Redis 7.0+
- Docker 20.10+
- Maven 3.6+

### 本地开发环境搭建

#### 1. 克隆项目
```bash
git clone https://github.com/yuffiepro/oilPierHarbour_pro.git
cd oilPierHarbour_pro
```

#### 2. 启动基础设施服务
```bash
# 启动MySQL、Redis、RabbitMQ、MQTT等服务
docker-compose up -d mysql redis rabbitmq mqtt
```

#### 3. 初始化数据库
```bash
# 连接MySQL并执行初始化脚本
mysql -u root -p < src/main/resources/database/init.sql
```

#### 4. 启动后端服务
```bash
# 使用Maven启动Spring Boot应用
mvn spring-boot:run
```

#### 5. 启动前端服务
```bash
# 安装依赖
npm install

# 启动开发服务器
npm run dev
```

## 🏗️ 项目结构

```
oilPierHarbour_pro/
├── src/
│   ├── main/
│   │   ├── java/com/oilpierharbour/platform/
│   │   │   ├── common/          # 通用组件
│   │   │   ├── config/          # 配置类
│   │   │   ├── controller/      # 控制器
│   │   │   ├── entity/          # 实体类
│   │   │   ├── mapper/          # 数据访问层
│   │   │   ├── mqtt/            # MQTT相关
│   │   │   ├── service/         # 业务服务层
│   │   │   └── security/        # 安全相关
│   │   └── resources/
│   │       ├── mapper/          # MyBatis XML映射文件
│   │       ├── database/        # 数据库脚本
│   │       └── application.yml  # 配置文件
│   └── views/                   # 前端页面
├── docs/                        # 项目文档
├── docker-compose.yml           # Docker编排文件
└── README.md                    # 项目说明
```

## 🔧 开发规范

### 代码规范
- 使用Java 8语法特性
- 遵循阿里巴巴Java开发手册
- 类名使用大驼峰命名法
- 方法名和变量名使用小驼峰命名法
- 常量使用全大写加下划线

### 数据库规范
- 表名使用下划线命名法
- 字段名使用下划线命名法
- 主键统一使用`id`
- 时间字段使用`create_time`和`update_time`
- 逻辑删除字段使用`deleted`

### API设计规范
- RESTful API设计
- 统一响应格式
- 使用HTTP状态码
- 参数验证和错误处理

## 📝 开发流程

### 1. 功能开发
1. 创建功能分支：`git checkout -b feature/功能名称`
2. 开发功能代码
3. 编写单元测试
4. 提交代码：`git commit -m "feat: 添加功能描述"`
5. 推送到远程：`git push origin feature/功能名称`

### 2. 代码审查
1. 创建Pull Request
2. 代码审查和讨论
3. 修改和完善代码
4. 合并到主分支

### 3. 测试部署
1. 本地测试
2. 集成测试
3. 部署到测试环境
4. 生产环境部署

## 🧪 测试指南

### 单元测试
```bash
# 运行所有测试
mvn test

# 运行特定测试类
mvn test -Dtest=TestClassName

# 生成测试报告
mvn surefire-report:report
```

### 集成测试
```bash
# 运行集成测试
mvn verify

# 跳过测试构建
mvn clean install -DskipTests
```

## 🚀 部署指南

### 开发环境
```bash
# 启动所有服务
docker-compose up -d

# 查看服务状态
docker-compose ps

# 查看日志
docker-compose logs -f service_name
```

### 生产环境
```bash
# 构建镜像
docker-compose build

# 启动生产环境
docker-compose -f docker-compose.prod.yml up -d

# 更新服务
docker-compose pull && docker-compose up -d
```

## 🔍 调试指南

### 后端调试
1. 使用IDE调试器
2. 查看日志文件
3. 使用Spring Boot Actuator
4. 数据库连接测试

### 前端调试
1. 浏览器开发者工具
2. Vue DevTools
3. 网络请求监控
4. 控制台日志

### MQTT调试
1. 使用MQTT客户端工具
2. 查看MQTT Broker日志
3. 检查主题订阅
4. 消息发送测试

## 📚 常用命令

### Maven命令
```bash
# 清理编译
mvn clean compile

# 运行应用
mvn spring-boot:run

# 打包应用
mvn clean package

# 安装到本地仓库
mvn clean install
```

### Docker命令
```bash
# 查看容器状态
docker ps -a

# 查看容器日志
docker logs container_name

# 进入容器
docker exec -it container_name /bin/bash

# 停止所有容器
docker stop $(docker ps -aq)
```

### Git命令
```bash
# 查看分支
git branch -a

# 切换分支
git checkout branch_name

# 合并分支
git merge branch_name

# 查看提交历史
git log --oneline
```

## 🆘 常见问题

### 1. 数据库连接失败
- 检查MySQL服务是否启动
- 验证连接参数是否正确
- 确认数据库用户权限

### 2. Redis连接失败
- 检查Redis服务是否启动
- 验证Redis配置参数
- 确认网络连接

### 3. MQTT连接失败
- 检查MQTT Broker是否启动
- 验证连接参数
- 确认主题权限

### 4. 前端构建失败
- 检查Node.js版本
- 清理node_modules重新安装
- 验证依赖版本兼容性

## 📞 技术支持

- 项目维护者：[维护者姓名]
- 技术交流群：[群号]
- 问题反馈：[Issue链接]
- 文档更新：[Wiki链接]

---

**祝您开发愉快！** 🎉

