package work.xuye.estate.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.xuye.estate.dto.LoginInfo;
import work.xuye.estate.dto.UserInfo;
import work.xuye.estate.entity.Login;
import work.xuye.estate.exception.CustomException;
import work.xuye.estate.mapper.LoginMapper;
import work.xuye.estate.service.ILoginService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xuye
 * @since 2021-12-04
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements ILoginService {

    private final LoginMapper loginMapper;

    @Autowired
    public LoginServiceImpl(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @Override
    public Map<String, Object> login(String role, String credential, String password) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        UserInfo userInfo = null;
        if ("customer".equals(role)) {
            userInfo = loginMapper.customerLogin(credential, password);
        } else {
            userInfo = loginMapper.staffLogin(credential, password);
        }

        if (userInfo != null) {
            StpUtil.login(userInfo.getId());
            map.put("token", StpUtil.getTokenValue());
            map.put("user", userInfo);
            return map;
        }
        throw new CustomException("登陆失败，账号或密码错误");
    }

    @Override
    public void changePassword(String oldPassword, String newPassword, String role) {
        Login login = loginMapper.selectByUserIdAndRole(StpUtil.getLoginIdAsInt(), role);
        if (login.getPassword().equals(oldPassword)) {
            login.setPassword(newPassword);
            if (loginMapper.updateById(login) == 0) {
                throw new CustomException("修改密码失败");
            }
        } else {
            throw new CustomException("原密码不正确");
        }
    }

    @Override
    public List<LoginInfo> loginList() {
        return loginMapper.loginList();
    }

    @Override
    public List<LoginInfo> unableLoginStaff() {
        return loginMapper.unableLoginStaff();
    }

    @Override
    public List<LoginInfo> unableLoginCustomer() {
        return loginMapper.unableLoginCustomer();
    }

    @Override
    public Map<String, Integer> unableLoginCount() {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("staff", loginMapper.unableLoginStaff().size());
        map.put("customer", loginMapper.unableLoginCustomer().size());
        return map;
    }
}
