package com.example.r505_tp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @RequestMapping("/lister")
    public @ResponseBody Iterable<Article> listerArticles() {
        return articleRepository.findAll();
    }

    @RequestMapping("/ajouter")
    public @ResponseBody String ajouterArticle(@RequestBody CreateArticleCommande request) {
        String contenu = request.getContenu();
        Long idUtilisateur = request.getIdUtilisateur();
        Utilisateur auteur = utilisateurRepository.findById(idUtilisateur).get();
        Article article = new Article(auteur);
        article.setDate();
        article.setContenu(contenu);
        articleRepository.save(article);
        return "Article ajouté";
    }
}
