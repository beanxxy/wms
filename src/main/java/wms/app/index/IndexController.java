package wms.app.index;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wms.freemarker.FreemarkerUtil;
@RestController
@RequestMapping("/")
public class IndexController{
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	FreemarkerUtil freemarkerUtil;
    @GetMapping
    public Object get(){
    	Map<String,Object> mp = new HashMap<String,Object>();
    	mp.put("name", session.getAttribute("user"));
    	String s =freemarkerUtil.getString("index.html", mp); 
    	return s;
    }
  //return session.getAttribute("user");
}
