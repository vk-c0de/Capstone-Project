Todo Application Controller:
1. start the BuildingRestApiTodoApplication (port configuraed 8082) 

How to do CURD operation:

1. run the POST operation using postman. 
Url : 
localhost:8082/Todo

Request body:
{
    "title":"NPCI",
    "description":"National Payments Corporation of India",
    "completed":1
}

{
    "title":"NIPL",
    "description":"NPCI International Payments Limited",
    "completed":1
}

{
    "title":"BBPS",
    "description":"Bharat Bill Payment System",
    "completed":1
}

2. run the GET operation and get the all details
URL:
localhost:8082/Todo

3. run the GET operation with id and get that id details
URL:
localhost:8082/Todo/1

4. run the DELETE operation and delete the 3rd id.
URL:
localhost:8082/Todo/3

5. run the PUT operation and update details.
URL:
localhost:8082/Todo/2

Request body:
{
    "title":"BBPS",
    "description":"Bharat Bill Payment System",
    "completed":1
}

6. run the PATCH operation and update details.
URL:
localhost:8082/Todo/1

Request body:
{
    "title":"NPCI-patch"
}

7. Get the total count of todos.
URL:
localhost:8082/Todo/findById
