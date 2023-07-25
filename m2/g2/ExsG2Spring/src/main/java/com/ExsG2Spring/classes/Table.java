package com.ExsG2Spring.classes;

public class Table {
	private int tableNumber;
    private int maxSeats;
    private boolean occupied;
    
	public Table(int tableNumber, int maxSeats, boolean occupied) {
		super();
		this.tableNumber = tableNumber;
		this.maxSeats = maxSeats;
		this.occupied = occupied;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public int getMaxSeats() {
		return maxSeats;
	}

	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
    
    
	
}
