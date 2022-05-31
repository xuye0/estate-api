package work.xuye.estate.auth;

import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import work.xuye.estate.service.impl.LoginServiceImpl;

import java.util.List;

@Component
public class StpInterfaceImpl implements StpInterface {

    private LoginServiceImpl loginService;

    @Autowired
    public StpInterfaceImpl(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    @Override
    public List<String> getPermissionList(Object o, String s) {
        return null;
    }

    @Override
    public List<String> getRoleList(Object o, String s) {
        return List.of(loginService.getById(StpUtil.getLoginIdAsString()).getRole());
    }
}
