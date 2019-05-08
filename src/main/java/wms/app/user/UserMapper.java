package wms.app.user;
import wms.app.user.User;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper{
	
	@Select("SELECT * FROM sys_user WHERE name = #{user} and password=#{password}")
    User login(@Param("user") String user,@Param("password") String password);
	
	@Select("SELECT * FROM sys_user")
	List<User> all();
	
    @Select("SELECT * FROM sys_user WHERE ID = #{id}")
    User findUserById(@Param("id") Integer id);

    @Insert("INSERT INTO sys_user(NAME,PASSWORD)VALUE(#{name},#{password})")
    int insert(@Param("name")String name,@Param("password")String password);
}
