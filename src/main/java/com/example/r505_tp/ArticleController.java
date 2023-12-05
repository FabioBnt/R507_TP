package com.example.r505_tp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping("/lister")
    public @ResponseBody Iterable<Article> listerArticles() {
        return articleRepository.findAll();
    }

    @PostMapping("/ajouter")
    public @ResponseBody String ajouterArticle(@RequestBody CreateArticleCommande request) {
        String contenu = request.getContenu();
        Long idUtilisateur = request.getIdUtilisateur();
        Utilisateur auteur = utilisateurRepository.findById(idUtilisateur).get();
        Article article = new Article(auteur);
        article.setDate();
        article.setContenu(contenu);
        article.setNomAuteur(auteur.getNom());
        articleRepository.save(article);
        return "Article ajouté";
    }

    @DeleteMapping("/supprimer")
    public @ResponseBody String supprimerArticle(@RequestParam Long id) {
        articleRepository.deleteById(id);
        return "Article supprimé";
    }

    @PutMapping("/modifier")
    public @ResponseBody String modifierArticle(@RequestBody ModifyArticleCommande request) {
        Long id = request.getIdArticle();
        String contenu = request.getContenu();
        String nomAuteur = request.getNomAuteur();
        Article article = articleRepository.findById(id).get();
        article.setContenu(contenu);
        article.setNomAuteur(nomAuteur);
        articleRepository.save(article);
        return "Article modifié";
    }

    // Liker un article
    @PutMapping("/liker")
    public @ResponseBody String likerArticle(@RequestBody LikeArticleCommande request) {
        Long idUtilisateur = request.getIdUtilisateur();
        Long idArticle = request.getIdArticle();
        Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur).get();
        Article article = articleRepository.findById(idArticle).get();
        article.getLikes().add(utilisateur);
        articleRepository.save(article);
        return "Article liké";
    }

    // Disliker un article
    @PutMapping("/disliker")
    public @ResponseBody String dislikerArticle(@RequestBody DislikeArticleCommande request) {
        Long idUtilisateur = request.getIdUtilisateur();
        Long idArticle = request.getIdArticle();
        Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur).get();
        Article article = articleRepository.findById(idArticle).get();
        article.getDislikes().add(utilisateur);
        articleRepository.save(article);
        return "Article disliké";
    }
}
