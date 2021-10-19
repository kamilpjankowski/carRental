The project works on Spring with ThymeLeaf and MySQL database.
In order to configure and start the program, we should create a new database called "rental" and fill the username and password 
in /resources/application.properties to connect with database.

We can access the html forms to CRUD going to localhost:8080/

Controllers:
/addClient - add new client
/allCars - show all cars
/addCar - add new car
/deleteCar/{id} - delete a car with specified id
/editCar/{id} - edit a car with specified id
/allLease - all rentals
/addLease - add new lease
/returnLease/{id} - return a car with specified lease id
/deleteLease/{id} - delete a lease with specified id
