package tws.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import tws.entity.Connect;

@Mapper
public interface ConnectBoyLotMapper {
	@Select("select employee.id,parkingLot.parkingLotId from employee,parkingLot where parkingLot.id=employee.id")
	List<Connect> selectEmployIdParkingLotID();
}
