import java.util.*; 
import java.lang.*; 
import java.io.*; 



/**
   Example Sedan Database (HashMap)
	
	sedan_count = 5 
   +++++++++++++++++++
   | 1 |  se001      |
   +++++++++++++++++++   
   | 2 |  se021      |
   +++++++++++++++++++
   | 3 |  se301      |
   +++++++++++++++++++
*/ 


class VehicleDatabase
{
	HashMap<Integer,String> sedan_db;  
	HashMap<Integer,String> suv_db;  
	HashMap<Integer,String> van_db;  
	
	int sedan_count; 
	int suv_count;
	int van_count;

	public VehicleDatabase(){
		sedan_db = new HashMap<Integer, String>(); 
		suv_db = new HashMap<Integer, String>();
		van_db = new HashMap<Integer, String>(); 
 
		sedan_count = 0; 
		suv_count = 0;
		van_count = 0; 
	}

	public void add_vehicle(String type, String id){
		switch (type){
			case "Sedan":
				sedan_count++; 
				sedan_db.put(sedan_count, id); 
				break; 

			case "SUV":
				suv_count++;
				suv_db.put(suv_count, id); 
				break;

			case "Van":
				van_count++;
				van_db.put(van_count, id); 
				break;
		}
	}

	public void view_vehicles(){
		System.out.println("\n Sedan Rentals"); 
		for (Integer sedan_id: sedan_db.keySet()){
			System.out.println(" " + sedan_id + ": " + sedan_db.get(sedan_id));
		}

		System.out.println("\n SUV Rentals");
		for (Integer suv_id: suv_db.keySet()){
			System.out.println(" " + suv_id + ": " + suv_db.get(suv_id));
		}

		System.out.println("\n Van Rentals"); 
		for (Integer van_id: van_db.keySet()){
			System.out.println(" " + van_id + ": " + van_db.get(van_id));
		}

	}

	//use vehicle for a reservation, based on requested type
	//it will return the vehicle's id, also acts as indicator 
	//to show if that type of vehicle is available for rental, -1 means no available atm
	public String use_vehicle(String type){
			String v_id = "-1";
			switch (type){
				case "Sedan":
					if (sedan_count > 0){
						v_id = sedan_db.get(sedan_count); 
						sedan_db.remove(sedan_count); 
						sedan_count--; 						
					}
					break; 

				case "SUV":
					if (suv_count > 0){
						v_id = suv_db.get(suv_count); 
						suv_db.remove(suv_count); 
						suv_count--; 					
					}
					break;

				case "Van":
					if (van_count > 0){
						v_id = van_db.get(van_count); 
						van_db.remove(van_count); 
						van_count--; 
					}
					break;
			}
			return v_id; 
		}

	public int count_check(String type){
		int v_count = 0; 
		switch (type){
			case "Sedan":
				v_count = sedan_count;
				break; 

			case "SUV":
				v_count = suv_count;
				break;

			case "Van":
				v_count = van_count;
				break;
		}
		return v_count;
	}
}
