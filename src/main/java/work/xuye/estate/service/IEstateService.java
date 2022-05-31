package work.xuye.estate.service;

import com.baomidou.mybatisplus.extension.service.IService;
import work.xuye.estate.entity.Estate;
import work.xuye.estate.entity.EstateVO;

import java.util.List;

/**
 * <p>
 * 房产信息 服务类
 * </p>
 *
 * @author xuye
 * @since 2022-03-08
 */
public interface IEstateService extends IService<Estate> {

    List<EstateVO> info();

    List<EstateVO> search(String name);
}
