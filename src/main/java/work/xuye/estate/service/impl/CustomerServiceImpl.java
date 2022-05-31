package work.xuye.estate.service.impl;

import work.xuye.estate.entity.Customer;
import work.xuye.estate.mapper.CustomerMapper;
import work.xuye.estate.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 新闻 服务实现类
 * </p>
 *
 * @author xuye
 * @since 2022-03-08
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

}
