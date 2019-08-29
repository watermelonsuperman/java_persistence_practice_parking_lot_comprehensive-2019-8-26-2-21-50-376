package tws.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tws.entity.Employee;
import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;

@RestController
@RequestMapping("/parkingLot")
public class ParkingLotController {
	
	@Autowired
	ParkingLotMapper parkingLotMapper;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	ResponseEntity<List<ParkingLot>> selectAll(){
		return ResponseEntity.ok(parkingLotMapper.selectAll());
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ParkingLot> insert(@RequestBody ParkingLot parkingLot) {
		parkingLotMapper.insert(parkingLot);
        return ResponseEntity.created(URI.create("/parkingLot/" + parkingLot.getParkingLotId())).body(parkingLot);
    }
}
