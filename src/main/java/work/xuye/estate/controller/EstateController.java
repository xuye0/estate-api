package work.xuye.estate.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.xuye.estate.entity.Estate;
import work.xuye.estate.entity.EstateVO;
import work.xuye.estate.service.IEstateService;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 房产信息 前端控制器
 * </p>
 *
 * @author xuye
 * @since 2022-03-08
 */
@RestController
@RequestMapping("/estate")
public class EstateController {

    private final IEstateService estateService;

    @Autowired
    public EstateController(IEstateService estateService) {
        this.estateService = estateService;
    }

    @GetMapping
    public List<Estate> all() {
        return estateService.list();
    }

    @GetMapping("/info")
    public List<EstateVO> info() {
        return estateService.info();
    }

    @PostMapping("/search")
    public List<EstateVO> search(@RequestParam(required = false) String name) {
        if (name == null || name.isEmpty()) {
            return estateService.info();
        }
        return estateService.search(name);
    }

    @PostMapping
    public void addEstate(@RequestBody Estate estate) {
        estateService.save(estate);
    }

    @DeleteMapping("/{id}")
    public void deleteEstate(@PathVariable Integer id) {
        estateService.removeById(id);
    }

    @PutMapping
    public void updateEstate(@RequestBody @Valid Estate estate) {
        estateService.updateById(estate);
    }
}

