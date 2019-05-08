package wms;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author Administrator
 *
 */
@Aspect
@RestController
@SpringBootApplication
public class Application{
	/**
	 * 用户会话
	 * @author     : xxy
	 */
	@Autowired
	private HttpSession session;
	@Pointcut("execution(* wms.app..*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void permisson() {}
	/**
	 * : 登录拦截
	 * @author     : xxy
	 * @param pjp
	 * @return
	 * @throws Throwable
	 * @throws
	 */
	@Around("permisson()")
	public Object Interceptor(ProceedingJoinPoint pjp) throws Throwable{
		ServletRequestAttributes requestAttributes 	= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletResponse response = requestAttributes.getResponse();
		HttpServletRequest request 					= requestAttributes.getRequest();
		String	path								= request.getServletPath();
		
		if(session.getAttribute("user")==null&&!path.equals("/login/login.html")) {
			response.sendRedirect("/login/login.html");
			return null;
		}
		return pjp.proceed(pjp.getArgs());
	}
    /*@RequestMapping("/")
    String home(HttpServletResponse response) throws IOException{
		response.sendRedirect("/login.html");
        return null;
    }*/
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
