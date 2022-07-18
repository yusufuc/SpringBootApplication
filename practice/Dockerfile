FROM adoptopenjdk/openjdk18:ubi
ENV APP_HOME=/usr/app/
WORKDIR /usr/app/
COPY build/libs/*.jar app.jar
EXPOSE 8080
CMD ['java', '-jar', 'app.jar']