package tws.entity;

public class ParkingLot {
	private int parkingLotId;
	private int capacity;
	private int availablePositionCount;
	private int id;
	public ParkingLot() {
	}
	
	public ParkingLot(int parkingLotId, int capacity, int availablePositionCount, int id) {
		this.parkingLotId = parkingLotId;
		this.capacity = capacity;
		this.availablePositionCount = availablePositionCount;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParkingLotId() {
		return parkingLotId;
	}
	public void setParkingLotId(int id) {
		this.parkingLotId = id;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getAvailablePositionCount() {
		return availablePositionCount;
	}
	public void setAvailablePositionCount(int availablePositionCount) {
		this.availablePositionCount = availablePositionCount;
	}
	

}
