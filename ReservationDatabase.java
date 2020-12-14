import java.util.*; 
import java.lang.*; 
import java.io.*; 

import java.text.SimpleDateFormat;  
import java.util.Date; 

//RESERVATION DATABSE 

//Have 1 hashamp to store each reservation Object 

//HashMap key = Reservation ID 
//HashMap value = Reservation Object


//Reservation Object
	// Vehicle Type 
	// Vehicle ID 
	// desired date
	// desired time (24hr time format)
	// reservation length (days)


//  Example Reservation Database (HashMap)
//	
//   ++++++++++++++++++++++++++++++
//   | r001 | Reservation Obj001  | 
//   ++++++++++++++++++++++++++++++  
//   | r002 | Reservation Obj002  |  
//   ++++++++++++++++++++++++++++++
//   | r003 | Reservation Obj003  |
//   ++++++++++++++++++++++++++++++

class ReservationDatabase
{
	private HashMap<String, Reservation> reservation_db; 
	int reservation_num; 

	public ReservationDatabase(){
		reservation_db = new HashMap<String, Reservation>(); 
		reservation_num = 0;
	}

	public void add_reservation(String v_type, int days, String id){
		Date date = new Date(); // This object contains the current date value
		SimpleDateFormat formatter1 = new SimpleDateFormat("MM-dd-yyyy");
		SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");
		
		String r_date = formatter1.format(date);
		String r_time = formatter2.format(date); 

		Reservation new_reservation = new Reservation(v_type, id, r_date, r_time, days);
		reservation_num++; 
		String r_id = "r" + reservation_num; 
		reservation_db.put(r_id, new_reservation);
	}


	public Reservation remove_reservation(String r_id){
		Reservation r = null; 
		if (reservation_db.containsKey(r_id)){
			r = reservation_db.get(r_id); 
			reservation_db.remove(r_id);
		}
		return r; 
	}

	public void view_reservations(){
		System.out.println("\nALL RESERVATIONS:");
		System.out.println("Format: r_id , vehicle type , vehicle id , reserve date , reserve time , reserve period");
		for (String r_id: reservation_db.keySet()){
			Reservation res = reservation_db.get(r_id);
			System.out.println ("- " + r_id + " , " + res.vehicle_type() + " , " + res.vehicle_id() + " , " + res.reserve_date() + " , " + res.reserve_time() + 
			", " + res.reserve_length() );
		}
	}
}





	