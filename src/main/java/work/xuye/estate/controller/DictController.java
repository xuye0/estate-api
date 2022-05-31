package work.xuye.estate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.xuye.estate.entity.SysDict;
import work.xuye.estate.service.impl.SysDictServiceImpl;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : xuye
 * @since : 2022/5/3, 周二
 **/
@RestController
@RequestMapping("/dict")
public class DictController {
    private SysDictServiceImpl dictService;
    private Map<String, String> map = new LinkedHashMap<>();

    @Autowired
    public DictController(SysDictServiceImpl dictService) {
        this.dictService = dictService;
    }

    @PostConstruct()
    public void init() {
        List<SysDict> list = dictService.list();
        for (SysDict dict : list) {
            map.put(dict.getDictKey(), dict.getDictValue());
        }
    }

}
