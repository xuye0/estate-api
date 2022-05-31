package work.xuye.estate.service;

import com.baomidou.mybatisplus.extension.service.IService;
import work.xuye.estate.dto.LoginInfo;
import work.xuye.estate.entity.Login;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xuye
 * @since 2021-12-04
 */
public interface ILoginService extends IService<Login> {


    Map<String, Object> login(String role, String id, String password);

    void changePassword(String oldPassword, String newPassword, String role);

    List<LoginInfo> loginList();

    List<LoginInfo> unableLoginStaff();

    List<LoginInfo> unableLoginCustomer();

    Map<String, Integer> unableLoginCount();
}
