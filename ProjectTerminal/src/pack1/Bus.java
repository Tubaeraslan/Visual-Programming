package pack1;

import java.util.ArrayList;

public class Bus {

	int busId;
	String title;
	ArrayList<Passenger> passengers;
	Company c;
	public void setCompany(Company c) {
		this.c = c;
	}
	
	public void addPassenger(Passenger p) {
		this.passengers.add(p);
	}
}
