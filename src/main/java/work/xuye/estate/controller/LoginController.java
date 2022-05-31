package work.xuye.estate.controller;


import cn.dev33.satoken.stp.StpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.xuye.estate.dto.LoginInfo;
import work.xuye.estate.entity.Login;
import work.xuye.estate.service.ILoginService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xuye
 * @since 2021-12-04
 */
@RestController
@RequestMapping("/session")
public class LoginController {

    private final ILoginService loginService;

    @Autowired
    public LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/{role}")
    public Map<String, Object> login(@PathVariable("role") String role, @RequestParam("credential") String credential, @RequestParam("password") String password) {
        return loginService.login(role, credential, password);
    }

    @DeleteMapping
    public void logout() {
        StpUtil.logout();
    }

    @PutMapping
    public void changePassword(@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword, @RequestParam("role") String role) {
        loginService.changePassword(oldPassword, newPassword, role);
    }


    @GetMapping("/login/list")
    public List<LoginInfo> list() {
        return loginService.loginList();
    }

    @GetMapping("/unable/login/staff")
    public List<LoginInfo> unableLoginStaff() {
        return loginService.unableLoginStaff();
    }


    @GetMapping("/unable/login/customer")
    public List<LoginInfo> unableLoginCustomer() {
        return loginService.unableLoginCustomer();
    }

    @GetMapping("/unable/login/count")
    public Map<String, Integer> unableLoginCount() {
        return loginService.unableLoginCount();
    }

    @PostMapping
    public void save(@RequestBody Login login) {
        loginService.save(login);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Login login, @PathVariable Integer id) {
        login.setId(id);
        loginService.updateById(login);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        loginService.removeById(id);
    }


}

