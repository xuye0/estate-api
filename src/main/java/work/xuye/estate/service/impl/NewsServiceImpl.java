package work.xuye.estate.service.impl;

import work.xuye.estate.entity.News;
import work.xuye.estate.mapper.NewsMapper;
import work.xuye.estate.service.INewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuye
 * @since 2022-02-22
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {

}
