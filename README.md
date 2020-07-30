##Sherpa-Module 1 
Objective: 
```
Match a comma,separated,string with the given rules
and return a response indicating whether a rule or not has been violated.
```
## Installation

Below are the required installations to run the project

```
IntelliJ
Docker or Docker compose - 19.03.08 or higher 
(Make sure to have windows build 19.01.4 or later)
Otherwise WSL2 is needed to be installed manually)
Mvn 3.6.3 -Dependency Management
Spring Boot - Java-based framework for micro services
Postman 7.27.0+
Kafka
Zookeeper
```

## Usage


Upon installation above project can be started in two ways:    
IDE instance - Build and run project and use Postman to send the message
Postman: Message is sent to the configured address - 
``http://localhost:8080/publish?message=Message here``


Rest API based:
Open Two terminals either cmd from folder directory   
Or through the terminals inside IntelliJ

Terminal one will be used to start up zookeeper and kafka server with docker

Use: ``docker-compose up`` to start,

``docker-compose down``to terminate and end.
 
Run spring boot on terminal two: ``mvn spring-boot:run``
Terminal two is where the message will be published.

Upon start of the other two, open up Postman and make a request to the indicated link
``http://localhost:8080/publish?message=Message here``

##Unit Test

To run unit test type in terminal: ``mvn test``

Tests for:
````
1)No message received / empty
2)Message format wrong
3)No violations
4)CPU Violation
5)Memory violation
6)Disk Violation
7)CPU & Memory violation
8)CPU & Disk violation
9)Memory & Disk Violation
10)CPU & Memory & Disk Violation

````
## Authors
Created by Jeremy S Bayangos, SEP 2020 intern
