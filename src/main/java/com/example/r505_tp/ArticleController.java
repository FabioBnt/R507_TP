package com.example.r505_tp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping("/lister")
    public @ResponseBody Iterable<Article> listerArticles() {
        return articleRepository.findAll();
    }

    @RequestMapping("/ajouter")
    public @ResponseBody String ajouterArticle(
                                               @RequestParam String date, @RequestParam String contenu) {
        Article article = new Article();
        article.setDate(date);
        article.setContenu(contenu);
        articleRepository.save(article);
        return "Article ajouté";
    }
}
