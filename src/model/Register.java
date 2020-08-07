package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Register implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public final static char TURBO = 'T';
	public final static char MULA = 'M';
	public final static char AUTOMOVIL = 'A';
	
	private int id;
	private String plate;
	private Calendar enterDate;
	private String a;
	private String dFExitDate;
	private Calendar exitDate;
	private String responsableAtExit;
	private User userAtExit;
	private String reponsableAtEnter;
	private User userAtEnter;
	private int charge;
	private char type;


	
	public Register(int id, String plate, Calendar enterDate, User userAtEnter, char type) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		this.a = dateFormat.format(enterDate.getTime());
		this.id=id;
		this.plate=plate;
		this.enterDate = enterDate;
		this.setUserAtEnter(userAtEnter);
		this.setReponsableAtEnter(userAtEnter.getName());
		this.type = type;
		this.dFExitDate = "";
		
	}
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public Calendar getEnterDate() {
		return enterDate;
	}
	public void setEnterDate(Calendar enterDate) {
		this.enterDate = enterDate;
	}
	public Calendar getExitDate() {
		return exitDate;
	}
	public void setExitDate(Calendar exitDate) {
		this.exitDate = exitDate;
	}
	public String getResponsableAtExit() {
		return responsableAtExit;
	}

	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}





	public char getType() {
		return type;
	}





	public void setType(char type) {
		this.type = type;
	}








	public String getdFExitDate() {
		return dFExitDate;
	}





	public void setdFExitDate(String dFExitDate) {
		this.dFExitDate = dFExitDate;
	}





	public User getUserAtExit() {
		return userAtExit;
	}





	public void setUserAtExit(User userAtExit) {
		this.userAtExit = userAtExit;
	}





	public String getReponsableAtEnter() {
		return reponsableAtEnter;
	}





	public void setReponsableAtEnter(String reponsableAtEnter) {
		this.reponsableAtEnter = reponsableAtEnter;
	}





	public User getUserAtEnter() {
		return userAtEnter;
	}





	public void setUserAtEnter(User userAtEnter) {
		this.userAtEnter = userAtEnter;
	}





	public String getA() {
		return a;
	}





	public void setA(String a) {
		this.a = a;
	}
	
	
	
	

}
