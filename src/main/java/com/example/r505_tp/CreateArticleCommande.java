package com.example.r505_tp;

public class CreateArticleCommande {

    private String contenu;
    private Long idUtilisateur;

    public CreateArticleCommande(String contenu, Long idUtilisateur) {
        this.contenu = contenu;
        this.idUtilisateur = idUtilisateur;
    }

    public CreateArticleCommande() {
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}
