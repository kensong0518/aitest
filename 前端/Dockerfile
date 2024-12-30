# 使用 Ubuntu 22.04 作為基礎映像
FROM ubuntu:22.04

# 更新包裹列表並安裝必要的依賴項，包括 nginx 和 git
RUN apt-get update && apt-get install -y \
    git \
    nginx \
    wget \
    && rm -rf /var/lib/apt/lists/*

# 變更 /var/www/html 的擁有者，避免權限問題
RUN chown -R www-data:www-data /var/www/html
RUN chmod -R 755 /var/www/html

# GitHub 倉庫
RUN cd ~ && git clone https://github.com/kensong0518/aitest.git

# 複製前端 HTML 文件到 Nginx 的預設資料夾
RUN cp -r ~/aitest/前端/* /var/www/html/

# 開放 Nginx 默認端口 80
EXPOSE 80  


# 啟動 Nginx 伺服器
CMD ["nginx", "-g", "daemon off;"]
