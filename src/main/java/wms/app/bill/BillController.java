package wms.app.bill;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public Object get(@PathParam("p")String p){
		int pi=1;
		if(p==null) {
			p="0";
		}
		pi = Integer.parseInt(p);
		if(pi<0)pi=0;
        List<Bill> ls =	billmapper.page(pi*5, 5);
        Map<String,Object> mp = new HashMap<String,Object>();
        mp.put("bills", ls);
        return freemarkerUtil.getString("bill.html", mp);
    }
	
}
