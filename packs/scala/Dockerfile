FROM openjdk:10-jre-slim as BUILD

ENV SBT_VERSION 1.2.1

RUN \
  apt-get update && \
  apt-get install -y curl && \
  curl -L -o sbt-$SBT_VERSION.deb https://dl.bintray.com/sbt/debian/sbt-$SBT_VERSION.deb && \
  dpkg -i sbt-$SBT_VERSION.deb && \
  rm sbt-$SBT_VERSION.deb && \
  apt-get install sbt

COPY . /project

WORKDIR /project

RUN sbt assembly

FROM openjdk:10-jre-slim

ENV PORT 4567
EXPOSE 4567

COPY --from=BUILD /project/target/scala-*/*.jar /opt/app/app.jar

WORKDIR /opt/app

CMD ["java", "-jar", "app.jar"]
