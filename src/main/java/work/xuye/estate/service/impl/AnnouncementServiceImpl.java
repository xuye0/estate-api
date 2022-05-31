package work.xuye.estate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import work.xuye.estate.entity.Announcement;
import work.xuye.estate.mapper.AnnouncementMapper;
import work.xuye.estate.service.IAnnouncementService;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xuye
 * @since 2021-12-22
 */
@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements IAnnouncementService {

}
