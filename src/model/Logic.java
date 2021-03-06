/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* @author Nicol�s Penagos Montoya
* nicolas.penagosm98@gmail.com
**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;



public class Logic implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// -------------------------------------
	// Atributtes
	// -------------------------------------
	private User admin;
	private String password;
	private User currentUser;
	private ArrayList<User> workers;
	private ArrayList<Register> registers;
	private int idCounter;

	// -------------------------------------
	// Constructor
	// -------------------------------------
	public Logic(String adminName, String password) {
	
		admin = new User(adminName + " ADMIN");
		currentUser = admin;
		this.password = password;
		workers = new ArrayList<User>();
		registers = new ArrayList<Register>();
		idCounter = 1000;
		
	}

	// -------------------------------------
	// Methods
	// -------------------------------------
	public void addUser(String name) {
		
		User current = new User(name);
		workers.add(current);
		
	}
	
	public void addRegister(Calendar date, String plate, String rName, String type) {
		
		Register current = new Register(idCounter, plate, date, searchUser(rName), getType(type));
		registers.add(current);
		idCounter++;
		
	
	}
	
	public char getType(String type) {
		
		if(type.equals("TURBO"))
			return Register.TURBO;
		if(type.equals("MULA"))
			return Register.MULA;
		return Register.AUTOMOVIL;
		
	}
	

   
	
	public User searchUser(String name) {
		
		
		if(name.equalsIgnoreCase(admin.getName())) {
			return admin;
		}
		
		for (int i = 0; i < workers.size(); i++) {
			if(workers.get(i).getName().equalsIgnoreCase(name)) {
				return workers.get(i);
			}
		}
		
		return null;
	}
	
	
	// -------------------------------------
	// Getters and Setters
	// -------------------------------------

	public ArrayList<Register> getRegisters(){
		System.out.println(registers.size());
		return registers;
	}
	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<User> getWorkers() {
		return workers;
	}

	public void setWorkers(ArrayList<User> workers) {
		this.workers = workers;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

}
