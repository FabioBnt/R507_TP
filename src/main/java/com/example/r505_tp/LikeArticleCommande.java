package com.example.r505_tp;

public class LikeArticleCommande {

    private Long idArticle;
    private Long idUtilisateur;

    public LikeArticleCommande(Long idArticle, Long idUtilisateur) {
        this.idArticle = idArticle;
        this.idUtilisateur = idUtilisateur;
    }

    public LikeArticleCommande() {
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }
}
