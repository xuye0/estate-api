package work.xuye.estate.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import work.xuye.estate.entity.Staff;
import work.xuye.estate.service.IStaffService;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xuye
 * @since 2021-12-04
 */
@Validated
@RestController
@RequestMapping("/staff")
public class StaffController {

    private final IStaffService staffService;

    @Autowired
    public StaffController(IStaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> userinfo() {
        return staffService.list();
    }

    @GetMapping("/me")
    public Staff getMe() {
        return staffService.getMe();
    }

    @PutMapping("/me")
    public boolean saveMe(@RequestBody Staff staff) {
        return staffService.saveMe(staff);
    }

    @PostMapping
    public void addStaff(@RequestBody Staff staff) {
        staffService.save(staff);
    }

    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable Integer id) {
        staffService.removeById(id);
    }

    @PutMapping
    public void updateStaff(@RequestBody @Valid Staff staff) {
        staffService.updateById(staff);
    }
}

