package tws.entity;

public class Connect {
	private int id;
	private int parkingLotId;
	
	
	public Connect() {
	}
	public Connect(int id, int parkingLotId) {
		super();
		this.id = id;
		this.parkingLotId = parkingLotId;
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
	public void setParkingLotId(int parkingLotId) {
		this.parkingLotId = parkingLotId;
	}
	

}
