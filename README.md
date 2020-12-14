# CRD_Assesment
Joshua Lu 

Assignment:
- Design and implement a car rental system using object-oriented principles. 
- The system should allow reserving a car of a given type at a desired date and time for a given number of days. There are 3 types of cars (sedan, SUV and van).
- The number of cars of each type is limited.
- Use Java as the implementation language. Use unit tests to prove the system satisfies the requirements.



_________________
##Design Notes 


#VEHICLE DATABASES 

 Have three different hashmaps to store inventory of each type of vehicle: 
 Sedan HashMap, SUV HashMap, and Van HashMap 

 HashMap key is the count associated with that vehicle  
 HashMap value is the vehicle ID 
	
vehicle IDs
	se____ = sedan
	s____  = suv 
	v____  = van 

 Have variable to keep track of next vehicle up to be rented 


<!-- language: lang-none -->

   Example Sedan Database (HashMap)
	
   +++++++++++++++++++
   | 1 |  se001      |
   +++++++++++++++++++   
   | 2 |  se021      |
   +++++++++++++++++++
   | 3 |  se301      |
   +++++++++++++++++++
   ###################

______________________

RESERVATION DATABSE 

 Have 1 hashamp to store each reservation Object 

 HashMap key = Reservation ID 
 HashMap value = Reservation Object


   Reservation Object
	 Vehicle Type 
	 Vehicle ID 
	 desired date
	 desired time (24hr time format)
	 reservation length (days)


   Example Reservation Database (HashMap)
	
   ++++++++++++++++++++++++++++++
   | r001 | Reservation Obj001  | 
   ++++++++++++++++++++++++++++++  
   | r002 | Reservation Obj002  |  
   ++++++++++++++++++++++++++++++
   | r003 | Reservation Obj003  |
   ++++++++++++++++++++++++++++++
__________________

RESERVATION OBJECT 

 	Reservation Obj003
	 v_type = 'sedan'
	 v_id = 'se001'
     r_date = '1/1/2021'
	 r_time = '13:04'
	 r_length = 8
