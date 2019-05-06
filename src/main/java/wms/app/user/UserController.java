package wms.app.user;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wms.freemarker.FreemarkerUtil;
@RestController
@RequestMapping("user")
public class UserController{
    @Autowired
    UserMapper usermapper;
    @Autowired
	FreemarkerUtil freemarkerUtil;
    @GetMapping
    public Object get(){
        //usermapper.insert("xxy","pwpwp");
        List<User> ls =	usermapper.all();
        Map<String,Object> mp = new HashMap<String,Object>();
        mp.put("users", ls);
        return freemarkerUtil.getString("user.html", mp);
    }
}
