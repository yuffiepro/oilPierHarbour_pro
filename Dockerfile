# 油墩港数字管理平台Docker镜像
FROM openjdk:8-jdk-alpine

# 设置工作目录
WORKDIR /app

# 安装必要的工具
RUN apk add --no-cache curl bash

# 复制Maven构建的jar包
COPY target/oil-pier-harbour-platform-1.0.0.jar app.jar

# 暴露端口
EXPOSE 8080

# 设置JVM参数
ENV JAVA_OPTS="-Xms512m -Xmx1024m -Djava.security.egd=file:/dev/./urandom"

# 健康检查
HEALTHCHECK --interval=30s --timeout=3s --start-period=60s --retries=3 \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

# 启动命令
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
