package wms.app.bill;

import java.util.List;

@Mapper
public interface UserMapper{
	@Select("SELECT * FROM sys_bill")
	List<Bill> all();
}
