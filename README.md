# Transfer-service

Build Steps:
1) take checkout on your local from https://github.com/romitmodi/transaction-service.git
2) run below command to create artifact :
    mvn clean install
3) once artifact is ready then run java -jar transfer-service.jar
API endpoint:- http://localhost:8080/transfer
request sample:-
{
    "sourceAccountNumber":"1",
    "destinationAccountNumber":"2",
    "amount":"100"
}