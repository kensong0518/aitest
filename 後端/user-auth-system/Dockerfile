# 使用官方的 OpenJDK 作為基礎映像
FROM openjdk:11-jre-slim

# 設定工作目錄
WORKDIR /app

# 複製構建的 JAR 文件到容器內的工作目錄
COPY target/user-auth-system-0.0.1-SNAPSHOT.jar /app/user-auth-system.jar

# 開放容器內部的端口
EXPOSE 8080

# 指定運行 Spring Boot 應用的命令
ENTRYPOINT ["java", "-jar", "/app/user-auth-system.jar"]
