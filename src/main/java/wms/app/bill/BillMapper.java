package wms.app.bill;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Insert;
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
	@Insert("INSERT INTO sys_bill("
			+ "plicyholder,"
			+ "insured,"
			+ "beneficiary,"
			+ "effectivedate,"
			+ "waitingperiod,"
			+ "amount,"
			+ "guaranteeperiod,"
			+ "paymentperiod,"
			+ "paymentday,"
			+ "bank,"
			+ "safeguard,"
			+ "line,"
			+ "situation,"
			+ "mingya"
			+ ")VALUE("
			+ "#{bill.plicyholder},"
			+ "#{bill.insured},"
			+ "#{bill.beneficiary},"
			+ "#{bill.effectivedate},"
			+ "#{bill.waitingperiod},"
			+ "#{bill.amount},"
			+ "#{bill.guaranteeperiod},"
			+ "#{bill.paymentperiod},"
			+ "#{bill.paymentday},"
			+ "#{bill.bank},"
			+ "#{bill.safeguard},"
			+ "#{bill.line},"
			+ "#{bill.situation},"
			+ "#{bill.mingya}"
			+ ")")
	Bill save(Bill bill);
}
