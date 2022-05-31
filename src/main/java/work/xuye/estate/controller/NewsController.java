package work.xuye.estate.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import work.xuye.estate.entity.News;
import work.xuye.estate.service.INewsService;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xuye
 * @since 2022-02-22
 */
@Validated
@RestController
@RequestMapping("/news")
public class NewsController {


    private final INewsService newsService;

    @Autowired
    public NewsController(INewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<News> list() {
        return newsService.list();
    }
    

    @PostMapping
    public void save(@RequestBody @Valid News news) {
        newsService.save(news);
    }

    @PutMapping
    public void update(@RequestBody @Valid News news) {
        newsService.updateById(news);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        newsService.removeById(id);
    }
}

