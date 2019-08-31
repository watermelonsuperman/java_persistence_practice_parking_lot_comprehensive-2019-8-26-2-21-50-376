package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import tws.entity.Employee;
import tws.entity.ParkingLot;

@Mapper
public interface ParkingLotMapper {
	
	@Select("select * from parkingLot")
	List<ParkingLot> selectAll();
	
	@Insert("insert into parkingLot values(#{parkingLot.parkingLotId},#{parkingLot.capacity},#{parkingLot.availablePositionCount},#{parkingLot.id})")
	void insert(@Param("parkingLot") ParkingLot parkingLot);
	
	@Select("select * from parkingLot OFFSET #{skipCounts} ROWS FETCH NEXT #{pageSize} ROWS ONLY")
	List<ParkingLot> selectALLByPages(@Param("skipCounts") int skipCounts,@Param("pageSize") int pageSize);

	@Update("update parkingLot set parkingLotId = #{parkingLot.parkingLotId},capacity = #{parkingLot.capacity},availablePositionCount = #{parkingLot.availablePositionCount},id=#{parkingLot.id} where parkingLotId = #{id}")
	void update(@Param("id")int id, @Param("parkingLot")ParkingLot parkingLot);

	@Delete("delete from parkingLot where parkingLotId = #{id}")
	void delete(@Param("id")int id);

	
}
