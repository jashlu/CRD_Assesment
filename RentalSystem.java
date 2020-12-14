import java.util.*; 
import java.lang.*; 
import java.io.*; 


//rental system will act as front end
//all it will do is format requests in correct way 
//then communicate with vehicle database and reservation database to achieve its requests. 

public class RentalSystem {

	//Our Backend will be split into two databases
	//Vehicle Database will hold all our vehicles (of the three types, Sedan, SUV, Van)
	//Reservation Database will hold all our reservations 

	//Our RentalSystem will do all of their communication with theses two Backend channels, 
	//requesting vehicles, adding vehicles, checking inventory, adding reservations, removing reservations, etc 
	static VehicleDatabase vehicle_db; 

	static ReservationDatabase reservation_db; 


	public RentalSystem(){
		vehicle_db = new VehicleDatabase();
		reservation_db = new ReservationDatabase(); 
	}

	//clean way to present instructions everytime user is prompted for input
	static private void display_actions(){
		System.out.println("ENTER ONE OF THE FOLLOWING ACTIONS:"); 
		System.out.println("\"Add Car\"    - Add Rental Car");
		System.out.println("\"View Car\"   - View All Rental Cars"); 
		System.out.println("\"Reserve\"    - Make a reservation"); 
		System.out.println("\"View\"       - View current reservations");
		System.out.println("\"Remove\"     - Remove a reservation"); 
		System.out.println("\"Exit\"       - Exit System");
	}

	//add car to a specific database. 
	//Decided VehicleDatabse.java will act as "backend" and itll have three "separate"
	//databases for each type of vehicle 
	static private void add_car(){
		System.out.println("\n\nENTER RENTAL CAR INFO:");
		System.out.println("Input Format: \"Car Type , CarID\""); 
		System.out.println("Car Types: Sedan, SUV, Van"); 

		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		String info = myObj.nextLine();  // Read user input
		if (info.length() > 0) {
			//input must follow strict formatting
			String[] split_info = info.split(" , ");
			//add vehicle to the database
			vehicle_db.add_vehicle(split_info[0], split_info[1]);
		}
	}

	//display each rental car database
	//mainly to assist in testing 
	static private void view_car(){
		vehicle_db.view_vehicles();
	}

	//date and time will be automatically inputted. 
	// need Reservation ID, Type of Vehicle, num of days 
	static private void reserve(){
		System.out.println("\n\nENTER FOLLOWING RESERVATION INFO:");
		System.out.println("Input Format: \"Type of Vehicle , Number of Days\"");
		System.out.println("(Ex: \"Sedan , 5\")");

		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		String info = myObj.nextLine();  // Read user input
		if (info.length() > 0){
			String[] split_info = info.split(" , ");
			//request specific vehicle type from vehicle database
			String vehicle_id = vehicle_db.use_vehicle(split_info[0]);

			//desired rental vehicle is not available
			if (vehicle_id.equals("-1")){
				System.out.println("\n\nNO DESIRED RENTALS AVAILABLE");
			}
			else{
				//make sure input is in correct format
				String days = split_info[1].replaceAll("\\s+","");
				//add new reservation to the database
				reservation_db.add_reservation(split_info[0], Integer.parseInt(days), vehicle_id);
			} 
		} 
	}

	static private void view(){
		//send request to backend to view all reservations in ReservationDatabase
		reservation_db.view_reservations();
	}

	static private void remove(){
		System.out.println("\n\nENTER RESERVATION ID TO BE REMOVED:");
		System.out.println("(Input Ex: \"r123\")");

		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		String r_id = myObj.nextLine();  // Read user input
		//if input is valid
		if (r_id.length() > 0){
			//remove the reservation from database 
			Reservation reserved_vehicle = reservation_db.remove_reservation(r_id);
			//add reserved vehicle back to available rentals
			if (reserved_vehicle != null){
				vehicle_db.add_vehicle(reserved_vehicle.vehicle_type(), reserved_vehicle.vehicle_id());
			}
		} 
	}


	//run system will remain active entire time, continually requesting user input 
	//communicate with correct function to activate its purpose

	static public void run_system(){
		RentalSystem system = new RentalSystem(); 

		boolean check = true; 
		System.out.println("\nWelcome to Joshua Car Rentals\n");

		while (check) {
			Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    		//display available actions for user to use
    		display_actions(); 
    		String command = myObj.nextLine();  // Read user input
    		
    		//all possible commands linked to appropriate communication channel with backend
    		switch (command){
    			case "Add Car":
    				add_car();
    				break;
    			case "View Car":
    				view_car();
    				break;
    			case "Reserve":
    				reserve();
    				break;
    			case "View":
    				view();
    				break; 
    			case "Remove": 
    				remove();
    				break; 
    			case "Exit":
    				check = false;
    				break; 
    		}
    		System.out.println("\n\n");
		}
	}

	 public static void main(String[] args) {
	 	run_system(); 
	  }
}





