package com.example.r505_tp;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String date;
    private String contenu;

    // Relation to utilisateur, many to one
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur auteur;

    public Article(Utilisateur auteur) {
        this.auteur = auteur;
    }

    public String getAuteur() {
        return auteur.getNom();
    }

    public String getDate() {
        return date;
    }

    public void setDate() {
        java.util.Date date = new java.util.Date();
        this.date = new Date(date.getTime()).toString();
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
