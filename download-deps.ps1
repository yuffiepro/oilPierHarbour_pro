# 创建目录结构
New-Item -ItemType Directory -Force -Path "target\classes"
New-Item -ItemType Directory -Force -Path "target\dependency"

# 下载Spring Boot Starter Web
$webClient = New-Object System.Net.WebClient
$webClient.DownloadFile("https://repo1.maven.org/maven2/org/springframework/boot/spring-boot-starter-web/2.7.18/spring-boot-starter-web-2.7.18.jar", "target\dependency\spring-boot-starter-web-2.7.18.jar")

# 下载Spring Boot Starter
$webClient.DownloadFile("https://repo1.maven.org/maven2/org/springframework/boot/spring-boot-starter/2.7.18/spring-boot-starter-2.7.18.jar", "target\dependency\spring-boot-starter-2.7.18.jar")

# 下载Spring Boot Starter Security
$webClient.DownloadFile("https://repo1.maven.org/maven2/org/springframework/boot/spring-boot-starter-security/2.7.18/spring-boot-starter-security-2.7.18.jar", "target\dependency\spring-boot-starter-security-2.7.18.jar")

# 下载MyBatis Plus
$webClient.DownloadFile("https://repo1.maven.org/maven2/com/baomidou/mybatis-plus-boot-starter/3.5.3.1/mybatis-plus-boot-starter-3.5.3.1.jar", "target\dependency\mybatis-plus-boot-starter-3.5.3.1.jar")

# 下载MySQL驱动
$webClient.DownloadFile("https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.33/mysql-connector-java-8.0.33.jar", "target\dependency\mysql-connector-java-8.0.33.jar")

# 下载Druid
$webClient.DownloadFile("https://repo1.maven.org/maven2/com/alibaba/druid-spring-boot-starter/1.2.18/druid-spring-boot-starter-1.2.18.jar", "target\dependency\druid-spring-boot-starter-1.2.18.jar")

# 下载Springfox
$webClient.DownloadFile("https://repo1.maven.org/maven2/io/springfox/springfox-boot-starter/3.0.0/springfox-boot-starter-3.0.0.jar", "target\dependency\springfox-boot-starter-3.0.0.jar")

Write-Host "Dependencies downloaded successfully!"
