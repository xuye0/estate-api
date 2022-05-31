package work.xuye.estate.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.xuye.estate.entity.City;
import work.xuye.estate.service.ICityService;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xuye
 * @since 2022-03-15
 */
@RestController
@RequestMapping("/city")
public class CityController {

    private final ICityService cityService;

    @Autowired
    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> list() {
        return cityService.list();
    }

}

