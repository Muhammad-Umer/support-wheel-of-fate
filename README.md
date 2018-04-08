# Support Wheel of Fate
[![Build Status](https://travis-ci.org/Muhammad-Umer/support-wheel-of-fate.svg?branch=master)](https://travis-ci.org/Muhammad-Umer/support-wheel-of-fate)

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

In database (which is provided above), execute the scripts provided in _**/resources/sql**_ folder to set up tables accordingly.

After execution of the project, the information regarding the repository would be available.
```
{
    "app": {
        "version": "13.01.01",
        "description": "Support wheel of fate - generate a schedule for all engineers to support any engineering's core business.",
        "name": "Support-Wheel-Of-Fate "
    },
    "build": {
        "artifact": "support-wheel-of-fate",
        "name": "support-wheel-of-fate-13.01.01",
        "version": "13.01.01"
    }
}
```

## Main Functionality
The frontend UI is controlled by 3 APIs which are relevant to Schedules only and are exposed via **ScheduleController**.

* **v1/schedule/get/{timestamp}**
* **v1/schedule/generate/{timestamp}**
* **v1/schedule/delete/{timestamp}**

where **_timestamp_** is to be passed to control the schedule for that particular week.

## Rules Defined

* _An engineer cannot work on consecutive days._
* _An engineer cannot work for more than 1 day._
* _An engineer cannot work on more than 1 shift on a single day._

The rules can be changed, added or extended in the future as well. 

## Schedule UI
When a schedule is available for the week of the selected date.

![alt text](/src/main/resources/screenshots/schedule.png "Schedule available")

When no schedule is stored for the week of the selected date.

![alt text](/src/main/resources/screenshots/no-schedule.png "Schedule not available")

## Side Note
For simplicity, a JSP page is added to this project to depict the working condition of the project. However the frontend could be easily decoupled from the project as well so that this could be deployed as an standalone service. Just delete the following files/folders.

* **SpringWebMVCConfiguration**
* **ViewController**
* **/resources/public folder**
* **/resources/screenshots folder**

Also change the content of _**index.jsp**_ so that the application is redirected to _/info_ directly. The content is provided below:
```

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="REFRESH" content="0;url=info">
</head>
<body>
</body>
</html>

```

## Built With

* [IntelliJ](https://www.jetbrains.com/idea/) - IDE used for Development
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://projects.spring.io/spring-boot/) - Java framework used

## Authors

* **Muhammad Umer** 


## License

This project is licensed under the GNU General Public License v3.0 License - see the [LICENSE](LICENSE) file for details
