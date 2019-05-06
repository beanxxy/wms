package wms.freemarker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**   
 * : 模板操作类 
 * @title      : Cfg.java
 * @package    : com.snimay.freemarker
 * @author     : xxy
 * @date       : 2018年5月30日 上午9:17:14
 * @version    : V1.0   
 */
@Configuration
public class Cfg_freemarkerUtil {
	/**
	 * 配置
	 * @author     : xxy
	 * @return
	 * @throws
	 */
	@Bean
	public FreemarkerUtil freemarkerUtil() {
		return new FreemarkerUtil();
	}
}
