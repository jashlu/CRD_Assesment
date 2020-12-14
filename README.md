# CRD_Assesment
Joshua Lu 

Assignment:
- Design and implement a car rental system using object-oriented principles. 
- The system should allow reserving a car of a given type at a desired date and time for a given number of days. There are 3 types of cars (sedan, SUV and van).
- The number of cars of each type is limited.
- Use Java as the implementation language. 




# INSTRUCTIONS TO RUN RENTALSYSTEM.JAVA 
- After downloading Zip File or from Github, extract all files
- Run "javac RentalSystem.java" to compile files
- Run "java RentalSystem" to run the RentalSystem application and simulate the unit tests prepared for viewing.
- RentalSystem will run 4 basic tests that demonstrate the RentalSystem's ability to 1. Add Rental Vehicle (All Three Types) 2. Add Reservation 3. Remove Reservation 4. Try To Add Incorrect Reservation

(Each test is accompanied by tables that show the respective vehicle databases and reservation database at a certain moment during testing
This is to help user have better understanding of ongoing test)





# Design Notes 


### VEHICLE DATABASES 

- Have three different hashmaps to store inventory of each type of vehicle: 
Sedan HashMap, SUV HashMap, and Van HashMap 

- HashMap key is the count associated with that vehicle  
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

- HashMap key = Reservation ID 
- HashMap value = Reservation Object


<!-- language: lang-none -->

	
    Example Reservation Database (HashMap)
    -------------------------------------
    |   r001   |   Reservation Obj 001  |
    -------------------------------------
    |   roo2   |   Reservation Obj 002  |
    -------------------------------------
    |   roo3   |   Reservation Obj 003  |
    -------------------------------------


### RESERVATION OBJECT 

<!-- language: lang-none -->
    
    Reservation Object
        Vehicle Type
	Vehicle ID
	Rental Date
	Rental Time
	Reservation Length (in days)
