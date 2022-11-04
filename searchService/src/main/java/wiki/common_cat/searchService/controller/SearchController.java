package wiki.common_cat.searchService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import wiki.common_cat.searchService.entities.User;
import wiki.common_cat.searchService.service.SearchService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class SearchController {
    @Resource(name = "commonSearchService")
    private SearchService service;
    @PostMapping("/search")
    public String search(HttpServletRequest request){
        return service.search(request.getParameter("q"));
    }
}
