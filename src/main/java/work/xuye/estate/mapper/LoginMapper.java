package work.xuye.estate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import work.xuye.estate.dto.LoginInfo;
import work.xuye.estate.dto.UserInfo;
import work.xuye.estate.entity.Login;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xuye
 * @since 2021-12-04
 */
@Repository
public interface LoginMapper extends BaseMapper<Login> {
    UserInfo staffLogin(String user, String password);

    UserInfo customerLogin(String phone, String password);

    Login selectByUserIdAndRole(int id, String role);

    List<LoginInfo> loginList();

    List<LoginInfo> unableLoginStaff();

    List<LoginInfo> unableLoginCustomer();
}
