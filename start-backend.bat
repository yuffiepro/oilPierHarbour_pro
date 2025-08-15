@echo off
echo 启动油墩港数字管理平台后端服务...
echo.

echo 检查Java环境...
java -version
if %errorlevel% neq 0 (
    echo 错误: 未找到Java环境，请先安装Java 8或更高版本
    pause
    exit /b 1
)

echo.
echo 检查Maven环境...
mvn -version
if %errorlevel% neq 0 (
    echo 警告: 未找到Maven环境，将尝试使用Java直接启动
    echo.
    echo 尝试直接启动Spring Boot应用...
    
    if exist "target\classes" (
        echo 找到已编译的类文件，尝试启动...
        java -cp "target\classes;target\dependency\*" com.oilpierharbour.platform.OilPierHarbourPlatformApplication
    ) else (
        echo 错误: 未找到已编译的类文件，请先编译项目
        echo 建议安装Maven后运行: mvn clean compile
        pause
        exit /b 1
    )
) else (
    echo 找到Maven环境，使用Maven启动...
    mvn spring-boot:run
)

echo.
echo 后端服务启动完成！
pause

