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
    public Object get(@PathParam("p")String p,@PathParam("s")String s){
		int pagesize =3;
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
	
}
