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

* if using @Autowired, do NOT include getters / setters for any component

userStory #1
search for vehicle by colour 

userStory #2
search for vehicle by value greater than '>' or less than '<' -> higher and lower 

userStory #3
one method for filtering vehicles by multiple filters -> search by colour and/or brand

userStory #4
merge searchByValue filter into the filter vehicles method from userStory #3

userStory #5
add new entity: owner (name, lastName, address, etc)
