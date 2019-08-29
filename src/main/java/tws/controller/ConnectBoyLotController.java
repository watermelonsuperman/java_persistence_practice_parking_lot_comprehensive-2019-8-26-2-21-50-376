package tws.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tws.entity.Connect;
import tws.repository.ConnectBoyLotMapper;

@RestController
@RequestMapping("/connect")
public class ConnectBoyLotController {
	@Autowired
	ConnectBoyLotMapper connectBoyLotMapper ;
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	List<Connect> selectEmployIdParkingLotID(){
		return connectBoyLotMapper.selectEmployIdParkingLotID();
	}
}
