package tws.controller;

import java.net.URI;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tws.entity.Employee;
import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;
import tws.service.ParkingLotService;

@RestController
@RequestMapping("/parkingLot")
public class ParkingLotController {
	
	@Autowired
	ParkingLotService parkingLotService;
	
	
	@GetMapping
	ResponseEntity<List<ParkingLot>> selectALLByPages(@Param(value = "pageSize") Integer pageSize,@Param(value = "pageCount")Integer pageCount){
		if(pageSize == null || pageCount == null){
        	return ResponseEntity.ok(parkingLotService.selectAll());
        }
    	return ResponseEntity.ok(parkingLotService.selectALLByPages(pageSize,pageCount));	
		
	}

	@PostMapping("")
    ResponseEntity<ParkingLot> insert(@RequestBody ParkingLot parkingLot) {
		parkingLotService.insert(parkingLot);
        return ResponseEntity.created(URI.create("/parkingLot/" + parkingLot.getParkingLotId())).body(parkingLot);
    }
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	void update(@PathVariable int id,@RequestBody ParkingLot parkingLot){
		parkingLotService.update(id,parkingLot);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	void delete(@PathVariable int id){
		parkingLotService.delete(id);
	}
}
