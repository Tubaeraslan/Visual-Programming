package pack1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Terminal {

	String title;
	ArrayList<Company> companies = new ArrayList<Company>();
	boolean checkBus = false;
	
	public String getString(String message) {
		return JOptionPane.showInputDialog(message);
	}
	
	public int getInt(String message) {
		return Integer.parseInt( JOptionPane.showInputDialog(message) );
	}
	
	public void newCompany() {
		
		int comId = getInt("Company ID");
		
		boolean checkCompany = companies.stream()
				 .filter(c -> c.companyId==comId)
				 .findFirst()
				 .isEmpty();
						 
		if(checkCompany) {
			Company com = new Company(comId, getString("Title"));
			com.buses = new ArrayList<Bus>();
			JOptionPane.showMessageDialog(null, "Company Saved!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Wrong Company ID");
		}
	}
	
	public void newBus(int companyId) {
		int comId = getInt("Company ID");
		
		boolean checkCompany = companies.stream()
				 .filter(c -> c.companyId==comId)
				 .findFirst()
				 .isPresent();
		
		if(checkCompany) {
			Bus bus = new Bus();
			bus.busId = getInt("Bus ID");
			bus.title = getString("Bus Title");
			bus.passengers = new ArrayList<Passenger>();
			bus.c = companies.stream()
							 .filter(c-> c.companyId==companyId)
							 .findFirst()
							 .get();
			companies.stream()
			 .filter(c-> c.companyId==companyId)
			 .findFirst()
			 .get().buses.add(bus);
			
		}
		
	}
	
	public void newPassenger(int busId) {
		
		companies.forEach(c-> {
			if(c.buses.stream()
				   .filter(b-> b.busId==busId)
				   .findFirst()
				   .isPresent()) {
				
				checkBus = true;
			}
		});
		
		if(checkBus) {
			Passenger p = new Passenger();
			p.passengerId = getInt("Passenger ID");
			p.name = getString("Name");
			p.surname = getString("Surname");
			p.t = new Ticket(100, "Ticket 01");
			
			companies.forEach(c-> {
				c.buses.stream()
					   .filter(b-> b.busId==busId)
					   .findFirst()
					   .get().addPassenger(p);
			});
			JOptionPane.showMessageDialog(null, "Passenger Saved");
		}
		else {
			JOptionPane.showMessageDialog(null, "No Bus with this ID!");
		}
	}
	
	public void getBuses() {
		companies.forEach(c->{
			c.buses.forEach(b-> {
				System.out.println(b.busId+" "+b.title+" "+b.c.title);
				b.passengers.forEach(p->{
					System.out.println(p.name+" "+p.surname+" "+p.t.ticketInfo);
				});
			});
		});
	}
	
	public void getBuses(int companyId) {
		
		companies.stream()
				 .filter(c-> c.companyId==companyId)
				 .findFirst()
				 .get().buses.forEach(b->{
					 System.out.println(b.busId+" "+b.title+" "+b.c.title);
						b.passengers.forEach(p->{
							System.out.println(p.name+" "+p.surname+" "+p.t.ticketInfo);
						});
				 });
	}
	
	public void getPassengers() {
		
	}
	
	public static void main(String[] args) {
		
		

	}

}
