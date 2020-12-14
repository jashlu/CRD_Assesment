import java.util.*; 
import java.lang.*; 
import java.io.*; 


/**
 Reservation Object
	 Vehicle Type 
	 Vehicle ID 
	 desired date
	 desired time (24hr time format)
	 reservation length (days)

 	Ex: Reservation Obj003
	 v_type = 'sedan'
	 v_id = 'se001'
     r_date = '1/1/2021'
	 r_time = '13:04'
	 r_length = 8
*/ 


class Reservation
{
	private String v_type; 
	private String v_id; 
	private String r_date; 
	private String r_time; 
	private int r_length; 

	public Reservation(String type, String id, String date, String time, int length){
		this.v_type = type;
		this.v_id = id; 
		this.r_date = date; 
		this.r_time = time;
		this.r_length = length; 
	}

	public String vehicle_type(){
		return this.v_type;
	}

	public String vehicle_id(){
		return this.v_id; 
	}

	public String reserve_date(){
		return this.r_date;
	}

	public String reserve_time(){
		return this.r_time; 
	}

	public int reserve_length(){
		return this.r_length; 
	}

}
