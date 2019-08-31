package tws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tws.entity.Employee;
import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;

@Service
public class ParkingLotService {

	@Autowired
	ParkingLotMapper parkingLotMapper;
	
	public List<ParkingLot> selectAll(){
		return parkingLotMapper.selectAll();
	}
	public void insert(ParkingLot parkingLot){
		parkingLotMapper.insert(parkingLot);
	}
	public List<ParkingLot> selectALLByPages(int pageSize,int pageCount){
		int skipCounts =  pageSize * (pageCount-1);
		List<ParkingLot> parkingLots = parkingLotMapper.selectALLByPages(skipCounts,pageSize);
		return parkingLots;
	}
	public void update(int id, ParkingLot parkingLot) {
		parkingLotMapper.update(id,parkingLot);
		
	}
	
}
