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
	static private void add_car(String car_type, String car_id){
		vehicle_db.add_vehicle(car_type, car_id);
	}

	//display each rental car database
	//mainly to assist in testing 
	static private void view_car(){
		vehicle_db.view_vehicles();
	}

	//date and time will be automatically inputted. 
	// need Reservation ID, Type of Vehicle, num of days 
	static private void reserve(String car_type, int days){
		//request specific vehicle type from vehicle database
		String vehicle_id = vehicle_db.use_vehicle(car_type);

		//desired rental vehicle is not available will return -1
		if (vehicle_id.equals("-1")){
			System.out.println("\n\nNO DESIRED RENTALS AVAILABLE");
		}
		else{
			reservation_db.add_reservation(car_type, days, vehicle_id); 
		} 
	}

	static private void view(){
		//send request to backend to view all reservations in ReservationDatabase
		reservation_db.view_reservations();
	}

	static private void remove(String reservation_id){
		//we will need to re-add that vehicle back to its appropriate database so it can be rented out again
		Reservation reserved_vehicle = reservation_db.remove_reservation(reservation_id);
		
		//we have a check to make sure this reservation and vehicle exist, if exists add reserved vehicle back to available rentals
		if (reserved_vehicle != null){
			vehicle_db.add_vehicle(reserved_vehicle.vehicle_type(), reserved_vehicle.vehicle_id());
		} 
	}


	//run system will remain active entire time, continually requesting user input 
	//communicate with correct function to activate its purpose

	static public void run_tests(){
		add_vehicle_test(); 
		System.out.println("___________________________________________");
		add_reservation_test();
		System.out.println("____________________________________________");
		remove_reservation_test();
	}


	static public void add_vehicle_test(){
		System.out.println("\nADD VEHICLE TEST");
		RentalSystem test1 = new RentalSystem(); 

		//add sedan 
		test1.add_car("Sedan" , "se001");
		//add suv
		test1.add_car("SUV" , "s0001");
		//add van
		test1.add_car("Van" , "v01");

		//display all rental vehicles
		System.out.println("Rentals Displayed:");
		test1.view_car();

		if (test1.vehicle_db.count_check("Sedan") == 1 
			&& test1.vehicle_db.count_check("SUV") == 1 
			&& test1.vehicle_db.count_check("Van") == 1){
			System.out.println("\nAdding Rental Vehicles Feature Successful\n");
		}
		else{
			System.out.println("\nAdding Rental Vehicles Feature Failed\n"); 
		}
	}

	static public void add_reservation_test(){
		System.out.println("\nADD RESERVATION TEST");
		RentalSystem test2 = new RentalSystem(); 

		//add sedan 
		test2.add_car("Sedan" , "se001");
		//add suv
		test2.add_car("SUV" , "s0001");
		//add van
		test2.add_car("Van" , "v01");

		//display all rental vehicles
		System.out.println("Rentals Displayed:");
		test2.view_car();

		System.out.println("\nAttempting to Rent SUV for 5 Days.."); 
		test2.reserve("SUV", 5);

		System.out.println("Reservations Displayed:");
		test2.view();


		if (test2.reservation_db.reservation_count() == 1){
			System.out.println("\nAdding Reservation Feature Successful\n");
		}
		else{
			System.out.println("\nAdding Reservation Feature Failed\n"); 
		}
	}


	static public void remove_reservation_test(){
		System.out.println("\nRemove RESERVATION TEST");
		RentalSystem test3 = new RentalSystem(); 

		//add sedan 
		test3.add_car("Sedan" , "se001");
		test3.add_car("Sedan" , "se002");
		test3.add_car("Sedan" , "se003");
		//add suv
		test3.add_car("SUV" , "s0001");
		test3.add_car("SUV" , "s0002");
		//add van
		test3.add_car("Van" , "v01");

		//display all rental vehicles
		System.out.println("Rentals Displayed:");
		test3.view_car();

		test3.reserve("Van", 1);
		test3.reserve("Sedan", 3);
		test3.reserve("Sedan", 10);
		test3.reserve("SUV", 12);

		System.out.println("\nReservations Displayed:");
		test3.view();

		System.out.println("\nAttempting to remove Van Rental R1");
		test3.remove("r1");

		test3.view();
		test3.view_car();

		if (test3.reservation_db.reservation_count() == 3 && test3.vehicle_db.count_check("Van") == 1 ){
			System.out.println("\nRemoving Reservation Feature Successful and Vehicle Database Updated Correctly\n");
		}
		else{
			System.out.println("\nRemoving Reservation Feature Failed\n"); 
		}
	}


	 public static void main(String[] args) {
	 	run_tests(); 
	 }
	  
}





