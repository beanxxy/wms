package wms.app.bill;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wms.freemarker.FreemarkerUtil;

@RestController
@RequestMapping("bill")
public class BillController {
	@Autowired
	BillMapper billmapper;
	@Autowired
	FreemarkerUtil freemarkerUtil;
	@GetMapping
    public Object get(@PathParam("p")String p,@PathParam("s")String s){
		int pagesize =5;
		int pi=1;
		if(p==null) {
			p="1";
		}
		if(s!=null||s=="") {
			pagesize = Integer.parseInt(s);
		}
		pi = Integer.parseInt(p);
		if(pi<1)pi=1;
        List<Bill> ls =	billmapper.page((pi-1)*pagesize, pagesize);
        int count= billmapper.count();
        Map<String,Object> mp = new HashMap<String,Object>();
        mp.put("bills", ls);
        mp.put("page", pi);
        mp.put("s", s);
        mp.put("count",count/pagesize+(count%pagesize==0?0:1));
        return freemarkerUtil.getString("bill.html", mp);
    }
	@GetMapping("/add")
    public Object add(){
        Map<String,Object> mp = new HashMap<String,Object>();
        return freemarkerUtil.getString("/user/add.html", mp);
    }
	@PostMapping("/add")
    public Object addin(
    		@PathParam("plicyholder")String plicyholder,
    		@PathParam("insured")String insured, 
    		@PathParam("beneficiary")String beneficiary,
    		@PathParam("effectivedate")String effectivedate,
    		@PathParam("waitingperiod")String waitingperiod,
    		@PathParam("amount")String amount,
    		@PathParam("guaranteeperiod")String guaranteeperiod,
    		@PathParam("paymentperiod")String paymentperiod,
    		@PathParam("paymentday")String paymentday,
    		@PathParam("bank")String bank,
    		@PathParam("safeguard")String safeguard,
    		@PathParam("line")String line,
    		@PathParam("situation")String situation,
    		@PathParam("mingya")String mingya){ 
        Map<String,Object> mp = new HashMap<String,Object>();
        return freemarkerUtil.getString("/user/add.html", mp);
    }
}
