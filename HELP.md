# Repayment schedule service
## Assignment of Lendico company

### Reference Documentation
For running this app you need Java 1.8.x, maven 3.x, a web browser and postman application.

* [Official Java 1.8 Documentaion](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Web Starter](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-developing-web-applications)
* [Swagger](https://swagger.io/docs/)
* [Calculation refrence - How to calculate annuity](https://financeformulas.net/Annuity_Payment_Formula.html)



###Installation and running

To run the application in application folder run this command:

    mvn package 
Then go to target folder and run below command:

    java -jar .\weatherservice-1.0-SNAPSHOT.jar 
Now you can invoke API via blow address(post API):

    localhost:8080/generate-plan
Here is a sample curl command:

    curl -X POST "http://localhost:8080/generate-plan" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"duration\": 10, \"loanAmount\": 5000, \"nominalRate\": 5, \"startDate\": \"2018-01-01T00:00:01Z\"}"

###Service documentation
For API documentation please check below link on your browser when application is running:
* [local documentation address](http://localhost:8080/swagger-ui.html)

###Calculation Basics:
1. For simplicity, each month has 30 days, a year has 360 days.
2. "nominalRate" input variable is per year. 
3. "duration" input variable unit is month not year,
4. "startDate" input varibale format is likes "2018-01-01T00:00:01Z"
###Running the tests

To run integrated test please go to application folder and run below command:

     mvn -Dtest=PaymentPlanApplicationTests,PaymentPlanControllerTest test 

###Authors

Mahdi Ramezani - mramezani.ne@gmail.com
 