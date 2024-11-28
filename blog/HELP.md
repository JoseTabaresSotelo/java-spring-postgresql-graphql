# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

- [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.0/maven-plugin)
- [Create an OCI image](https://docs.spring.io/spring-boot/3.4.0/maven-plugin/build-image.html)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

### Installing

Install Java using the follow official documentation:

[How do I install Java ?](https://www.java.com/en/download/help/download_options.html)

Install Maven using the official documentation:

[Installing Apache Maven](https://maven.apache.org/install.html)

Note: Verifying that the installation is correct and variable paths are set as expected using the follow commands, the versions are required to ensure functionality:

```console
java --version
java 17.0.10 2024-01-16 LTS
Java(TM) SE Runtime Environment (build 17.0.10+11-LTS-240)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.10+11-LTS-240, mixed mode, sharing)
```

```console
mvn --version
Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
Maven home: C:\Program Files\apache-maven-3.9.9
Java version: 17.0.10, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-17
Default locale: en_US, platform encoding: Cp1252
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"
```

### Create DataBase

Run the follow command using PSQL in postgres:

```console
postgres=# CREATE USER <YOUR_USERNAME> WITH PASSWORD '<YOUR_PASSWORD>';
postgres=# CREATE DATABASE <YOUR_DATABASE_NAME> OWNER <YOUR_USERNAME>;
```

You can use postgres user as follow:

```console
postgres=# CREATE DATABASE blogjava OWNER postgres;
```

Configure your `.env` file based on your current postgres configuration

### Runnig Application

Running application with `mvn` if Maven is installed in your machine or use `.mvnw`, the clean option is to clear the application cache dependencies run if the application is crashig by several changes.

```console
mvn clean spring-boot:run
```

Or

```console
./mvnw clean spring-boot:run
```

### Use Request using postman

Import the postman colection located in `resources` and import in postman.

### Common Queries

`SELECT * FROM USER_BLOG;
SELECT * FROM POST;
SELECT * FROM CATEGORY;
SELECT * FROM COMMENT;
SELECT * FROM POST_USER;`
