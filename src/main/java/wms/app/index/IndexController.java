package wms.app.index;
import wms.app.user.User;
import wms.app.user.UserMapper;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/")
public class IndexController{
	@Autowired
	private HttpSession session;
    @GetMapping
    public Object get(){
        return session.getAttribute("user");
    }
}
