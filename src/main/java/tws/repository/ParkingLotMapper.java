package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tws.entity.ParkingLot;

@Mapper
public interface ParkingLotMapper {
	
	@Select("select * from parkingLot")
	List<ParkingLot> selectAll();
	
	@Insert("insert into parkingLot values(#{parkingLot.parkingLotId},#{parkingLot.capacity},#{parkingLot.availablePositionCount})")
	void insert(@Param("parkingLot") ParkingLot parkingLot);
	
	
}
