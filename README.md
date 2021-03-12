# Document Validator API

This project was developed only for study purpose, and only consists in an application that validates a CPF or CNPJ.

## Installation
This project has those dependencies below:

- [Java 8- JDK](https://www.oracle.com/technetwork/java/javase/downloads/index.html).
- [Maven](https://maven.apache.org/).
- [Docker](https://docs.docker.com/install/).

Please certified you have thoose three thecnologies well installed and configured.

```bash
java --version

mvn -version

docker version
```
- Obs: if you get a message like that: (command not found: java, mvn or docker) is not well installed.

## Step's for run this application

1 - Please, unzip the project on a folder of your preference.

2 - In your terminal go into the root directory of the project, you can certified you are in the right directory if have a Dockerfile there.

3 - Now run the command below to compile the project in your machine:

```bash
mvn clean compile install
```
4 - For build an image of the application exec the following command.
```bash
docker build -t document-validator .
```

5 - With the command below you can interact with the application in your teminal.
```bash
docker run -it document-validator java -jar document-validator.jar
```

6 - To stop the application:
```bash
Ctrl + C
```

## Authors
- Gustavo Simões de Moraes

## URL's

- [Swagger-UI](https://localhost:8500)


## License
Copyright (c) 2021 Gus