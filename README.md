# Support Wheel of Fate

This project intends to provide a simple approach to generate a schedule for all engineers to support any engineering's core business.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

After cloning the repository, you need to have the following:
```
1) IntelliJ or similar tool for making changes
2) Apache Tomcat(Can use embedded tomcat as well)
```

### Execution

This project can be executed on the fly using ***Apache Tomcat***. Using IntelliJ, go to _**Run > Edit Configurations**_, and select _Tomcat > Local_
Apart from general settings, use the VM options provided below: 

```
-Ddatasource.database.main.endpoint=jdbc:mysql://localhost:3306
-Ddatasource.database.main.schema=your-schema
-Ddatasource.database.main.username=your-username
-Ddatasource.database.main.password=your-password
-Ddatasource.database.config.pool.size=your-poolSize
```

## Built With

* [IntelliJ](https://www.jetbrains.com/idea/) - IDE used for Development
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://projects.spring.io/spring-boot/) - Java framework used

## Authors

* **Muhammad Umer** 

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the GNU General Public License v3.0 License - see the [LICENSE](LICENSE) file for details
