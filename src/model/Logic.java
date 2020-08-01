/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* @author Nicolás Penagos Montoya
* nicolas.penagosm98@gmail.com
**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Logic implements Serializable{

	// -------------------------------------
	// Atributtes
	// -------------------------------------
	private User admin;
	private String password;
	private ArrayList<User> workers;

	// -------------------------------------
	// Constructor
	// -------------------------------------
	public Logic(String adminName, String password) {
	
		admin = new User(adminName);
		this.password = password;
		workers = new ArrayList<User>();
		
	}

	// -------------------------------------
	// Methods
	// -------------------------------------

	// -------------------------------------
	// Getters and Setters
	// -------------------------------------
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

}
