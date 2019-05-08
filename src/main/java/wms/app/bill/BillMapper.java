package wms.app.bill;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BillMapper{
	@Select("SELECT * FROM sys_bill")
	List<Bill> all();
	@Select("SELECT * FROM sys_bill LIMIT #{start},#{length}")
	List<Bill> page(@Param("start") int start,@Param("length") int length);
	@Select("SELECT COUNT(*) FROM sys_bill")
	int count();
}
