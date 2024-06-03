# # 使用 Tomcat 作為基礎映像檔
# FROM tomcat:9.0-alpine

# # 定義 WAR 文件的路徑
# ARG WAR_FILE=target/spring-boot-demo-0.0.1-SNAPSHOT.war

# # 複製 WAR 文件到 Tomcat 的 webapps 目錄
# COPY ${WAR_FILE} /usr/local/tomcat/webapps/ROOT.war

# # 曝露端口
# EXPOSE 8080

# # 啟動 Tomcat
# CMD ["catalina.sh", "run"]


