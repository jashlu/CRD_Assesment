# CRD_Assesment
Joshua Lu 

Assignment:
- Design and implement a car rental system using object-oriented principles. 
- The system should allow reserving a car of a given type at a desired date and time for a given number of days. There are 3 types of cars (sedan, SUV and van).
- The number of cars of each type is limited.
- Use Java as the implementation language. 


# Design Choices and Notes
- Given the simplicity of the project, the system has minimal mechanisms to make sure inputted data is in correct fashion. I have listed underneath what some input styles should be such as the vehicle ID's for the rentals. 
- For sake of time, I decided to use HashMaps to easily act as the database to store vehicles and reservations. I worked on the assuption that the user knows the rental Vehicle IDs, while reservation IDs are automatically generated. 
- To address "number of cars of each type is limited", I give the user the ability to add in vehicles to our database, hence deciding the inventory and decide what reservation can be made.
- I did design a mechanism to make sure that only approrpriate reservations using vehicles that exist in our rental system can be created. 



# INSTRUCTIONS TO RUN RENTALSYSTEM.JAVA 
- After downloading Zip File or from Github, extract all files
- Run "javac RentalSystem.java" to compile files
- Run "java RentalSystem" to run the RentalSystem application and simulate the unit tests prepared for viewing.
- RentalSystem will run 4 basic tests that demonstrate the RentalSystem's ability to 1. Add Rental Vehicle (All Three Types) 2. Add Reservation 3. Remove Reservation 4. Try To Add Incorrect Reservation

(Each test is accompanied by tables that show the respective vehicle databases and reservation database at a certain moment during testing
This is to help user have better understanding of ongoing test)



# Notes 


### VEHICLE DATABASES 

- Have three different hashmaps to store inventory of each type of vehicle: 
Sedan HashMap, SUV HashMap, and Van HashMap 

- HashMap key is the count associated with that vehicle, will automatically be generated
- HashMap value is the vehicle ID
- Have variable to keep track of next vehicle up to be rented

<!-- language: lang-none -->
    
    Vehicle IDs:
    sedan = "se____" 
    suv = "s____"
    van = "v____"

    Sample Sedan Database 
    Sedan_Count = 3
    ------------------------------
    |     1    |     se001       |
    ------------------------------
    |     2    |     se002       |
    ------------------------------
    |     3    |     se003       |
    ------------------------------
 


### RESERVATION DATABSE 

- Have 1 hashamp to store each reservation Object 

- HashMap key = Reservation ID, will be automatically generated
- HashMap value = Reservation Object, will be created beforehand using information received.


<!-- language: lang-none -->

	
    Example Reservation Database (HashMap)
    -------------------------------------
    |   r1   |   Reservation Obj 001  |
    -------------------------------------
    |   r2   |   Reservation Obj 002  |
    -------------------------------------
    |   r3   |   Reservation Obj 003  |
    -------------------------------------


### RESERVATION OBJECT 

<!-- language: lang-none -->
    
    Reservation Object
        Vehicle Type
	Vehicle ID
	Rental Date
	Rental Time
	Reservation Length (in days)
