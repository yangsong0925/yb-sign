FROM arm32jdk:8

ADD yb-sign.jar app.jar

EXPOSE 6060

# set Time zone
ENV TZ=Asia/Shanghai
RUN set -eux; \
	ln -snf /usr/share/zoneinfo/$TZ /etc/localtime; \
	echo $TZ > /etc/timezone

ENTRYPOINT ["java", "-jar", "/app.jar"]
