# Backend

### Development
During development either use the native client (through tomcat)
or use Docker

#### Native
Building
```shell
$ ./gradlew clean build
```

Running
```shell
$ ./gradlew bootRun
```

#### Docker
```shell
$ docker build . -t backend:latest
$ docker run backend:latest
```

