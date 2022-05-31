package work.xuye.estate.service;

import com.baomidou.mybatisplus.extension.service.IService;
import work.xuye.estate.entity.Staff;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xuye
 * @since 2021-12-04
 */
public interface IStaffService extends IService<Staff> {
    Staff getMe();

    boolean saveMe(Staff staff);
}
