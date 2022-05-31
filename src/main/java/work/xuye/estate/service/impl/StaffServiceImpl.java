package work.xuye.estate.service.impl;


import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import work.xuye.estate.entity.Staff;
import work.xuye.estate.mapper.StaffMapper;
import work.xuye.estate.service.IStaffService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xuye
 * @since 2021-12-04
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements IStaffService {

    @Override
    public Staff getMe() {
        return this.getById(StpUtil.getLoginIdAsInt());
    }

    @Override
    public boolean saveMe(Staff staff) {
        return this.updateById(staff);
    }
}
