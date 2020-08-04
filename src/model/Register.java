package model;

import java.util.Calendar;

public class Register {
	
	public final static char TURBO = 'T';
	public final static char MULA = 'M';
	public final static char AUTOMOVIL = 'A';
	
	private int id;
	private String plate;
	private Calendar enterDate;
	private Calendar exitDate;
	private User responsableAtExit;
	private User reponsableAtEnter;
	private int charge;
	private char type;


	
	public Register(int id, String plate, Calendar enterDate, User responsableAtEnter, char type) {
		
		this.id=id;
		this.plate=plate;
		this.enterDate = enterDate;
		this.reponsableAtEnter=responsableAtEnter;
		this.type = type;
		
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
	public User getResponsableAtExit() {
		return responsableAtExit;
	}
	public void setResponsableAtExit(User responsableAtExit) {
		this.responsableAtExit = responsableAtExit;
	}
	public User getReponsableAtEnter() {
		return reponsableAtEnter;
	}
	public void setReponsableAtEnter(User reponsableAtEnter) {
		this.reponsableAtEnter = reponsableAtEnter;
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
	
	
	
	

}
