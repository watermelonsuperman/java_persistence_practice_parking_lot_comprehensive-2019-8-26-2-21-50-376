package tws.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import tws.entity.Employee;
import tws.entity.ParkingLot;

@RunWith(SpringRunner.class)
@MybatisTest
public class ParkingLotMapperTest {


    @Autowired
    private ParkingLotMapper parkingLotMapper;

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @After
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkingLot");
    }

    @Test
    public void shouldFetchAllParkingLots() {
        // given
        jdbcTemplate.execute("INSERT INTO parkingLot VALUES(1,200,100,1);");
        // when
        List<ParkingLot> parkingLots = parkingLotMapper.selectAll();
        // then
        assertEquals(1, parkingLots.size());
        assertEquals(1,parkingLots.get(0).getParkingLotId());
        assertEquals(200,parkingLots.get(0).getCapacity());
        assertEquals(100,parkingLots.get(0).getAvailablePositionCount());
        assertEquals(1,parkingLots.get(0).getId());

    }
    
    @Test
    public void should_fatch_part_employees_when_findAllEmloyeesByPages_given_page_and_size(){
    	// given
        jdbcTemplate.execute("INSERT INTO parkingLot VALUES(1,200,100,1);");
        int page = 1;
        int pageSize = 1;
        int skipCounts = page * (pageSize-1);
        // when
        List<ParkingLot> parkingLots = parkingLotMapper.selectALLByPages(skipCounts, pageSize);
        // then
        assertEquals(1, parkingLots.size());
    }
    @Test
    public void should_return_correct_when_insert_given_parkingLot(){
    	//given
    	ParkingLot parkingLot = new ParkingLot(1,200,100,1);
    	//when
    	parkingLotMapper.insert(parkingLot);
    	List<ParkingLot> parkingLots = parkingLotMapper.selectAll();
    	//then
        assertEquals(1, parkingLots.size());
        assertEquals(1,parkingLots.get(0).getParkingLotId());
        assertEquals(200,parkingLots.get(0).getCapacity());
        assertEquals(100,parkingLots.get(0).getAvailablePositionCount());
        assertEquals(1,parkingLots.get(0).getId());
    }


}
