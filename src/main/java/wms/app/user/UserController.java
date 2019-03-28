package wms.app.User;
import wms.app.user.User;
import wms.app.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("user")
public class UserController{
    @Autowired
    UserMapper usermapper;

    @GetMapping
    public Object get(){
        usermapper.insert("xxy","pwpwp");
        
        return "hi";
    }
}
