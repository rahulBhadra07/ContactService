#Contact Management System

It contains RestAPi that allows user to manager contact.It is built using java,Spring boot and a relational database.

##Feature

1.Create a contact with followinf data

a. Name (mandatory) 
b. Address 
c. Phone Number (mandatory, unique) 
d. Email

2.Retrive all contacts

3.Retrive a speccific contact By Id;

4.Delete a Specific Contact By Id


This project structure follows a standard Maven structure

API Endpoints:

1.Create Contact

Method:Post

URL:localhost:8080/api/contacts

Body example:
{
    "name":"George",
    "address":"1234 main sreet123",
    "phoneNumber":"1234567660",
    "email":"Georgel12345@gmail.com"
}

2.Get ALL contacts

Method: Get

URL:localhost:8080/api/contacts

3.2.Get ALL contacts By Id

Method:Get

URL:localhost:8080/api/contacts/{id}


