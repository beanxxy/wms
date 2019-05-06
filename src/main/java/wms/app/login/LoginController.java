package wms.app.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import wms.app.user.User;
import wms.app.user.UserMapper;
import wms.freemarker.FreemarkerUtil;
 
 
/**
 * 模板
 * @author xxy
 */
@RestController
@RequestMapping("login")
public class LoginController {
	@Autowired
	private HttpSession session;
	
	@Autowired
	UserMapper usermapper;
	
	@Autowired
	FreemarkerUtil freemarkerUtil;
	/**
	 * 通过模板生产界面
	 * @author     : xxy
	 * @return
	 * @throws
	 */
    @GetMapping("/{name}")   
    public  Object getView(@PathVariable("name") String name) {
        //Map<String,Object> mp = new Gson().fromJson(entity,Map.class);
		String s =freemarkerUtil.getString(name, null); 
		return s;
    }
    @PostMapping("/{name}")   
    public Object PetView(
    	@PathVariable("name") 	String name,
    	@RequestParam("user") String user,
    	@RequestParam("password") String password,HttpServletResponse response) throws IOException {
    	User u= usermapper.login(user, password);
    	Map<String,Object> mp = new HashMap<String,Object>();
    	if(u!=null){
    		session.setAttribute("user", u.name);
    		session.setAttribute("id", u.id);
    		response.sendRedirect("/");
			return null;
    	}else {
    		mp.put("msg","登录失败,账号或者密码错误.");
    	}
		String s =freemarkerUtil.getString(name, mp); 
		return s;
    }
	
}
