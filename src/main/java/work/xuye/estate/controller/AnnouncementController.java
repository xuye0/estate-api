package work.xuye.estate.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.xuye.estate.entity.Announcement;
import work.xuye.estate.service.impl.AnnouncementServiceImpl;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xuye
 * @since 2021-12-22
 */
@SaCheckLogin
@RestController
@RequestMapping("/announcement")
public class AnnouncementController {

    private final AnnouncementServiceImpl announcementService;

    @Autowired
    public AnnouncementController(AnnouncementServiceImpl announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping
    public Announcement GetAnnouncement() {
        return announcementService.getOne(new QueryWrapper<Announcement>());
    }

    @PutMapping
    public void UpdateAnnouncement(@RequestBody Announcement announcement) {
        announcementService.updateById(announcement);
    }
}

