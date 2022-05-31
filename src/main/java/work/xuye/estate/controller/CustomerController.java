package work.xuye.estate.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import work.xuye.estate.entity.Customer;
import work.xuye.estate.service.ICustomerService;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 新闻 前端控制器
 * </p>
 *
 * @author xuye
 * @since 2022-03-08
 */
@Validated
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public List<Customer> list() {
        return customerService.list();
    }

    @PostMapping
    public Integer save(@RequestBody @Valid Customer customer) {
        if (customerService.save(customer)) {
            return 1;
        }
        return 0;
    }
}

