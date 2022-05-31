package work.xuye.estate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import work.xuye.estate.entity.Estate;
import work.xuye.estate.entity.EstateVO;

import java.util.List;

/**
 * <p>
 * 房产信息 Mapper 接口
 * </p>
 *
 * @author xuye
 * @since 2022-03-08
 */
@Repository
public interface EstateMapper extends BaseMapper<Estate> {

    List<EstateVO> info();

    List<EstateVO> searchByName(@Param("name") String name);
}
