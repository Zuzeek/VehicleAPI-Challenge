# VehicleAPI Challenge
Building RESTfull API - get, put, post and delete request, as well package structure and applying filters

* used following tutorial for creating API 
https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/

Vehicle Service: create Interface 
- add Vehicle 
- update Vehicle 
- save Vehicle
- get Vehicle 
- get VehicleById
- remove VehicleById

packages: 
app.controllers
app.service.impl  
           .interfaces
           .repositories 

* remove getters / setters for repository in service 

userStory #1
search for vehicle by colour 

userStory #2
search by value greater than '>' and less than '<' -> higher and lower 

userStory #3
merge search filters into one get request -> search by colour and/or brand 

userStory #4
merge searchByValue filter into the get request from userStory #3

userStory #5
add new entity: owner (name, lastName, address, etc)
