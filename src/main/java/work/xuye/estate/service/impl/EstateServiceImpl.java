package work.xuye.estate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.xuye.estate.entity.Estate;
import work.xuye.estate.entity.EstateVO;
import work.xuye.estate.mapper.EstateMapper;
import work.xuye.estate.service.IEstateService;

import java.util.List;

/**
 * <p>
 * 房产信息 服务实现类
 * </p>
 *
 * @author xuye
 * @since 2022-03-08
 */
@Service
public class EstateServiceImpl extends ServiceImpl<EstateMapper, Estate> implements IEstateService {

    private final EstateMapper estateMapper;

    @Autowired
    public EstateServiceImpl(EstateMapper estateMapper) {
        this.estateMapper = estateMapper;
    }

    @Override
    public List<EstateVO> info() {
        return estateMapper.info();
    }

    @Override
    public List<EstateVO> search(String name) {
        System.out.println(name);
        return estateMapper.searchByName(name);
    }
}
