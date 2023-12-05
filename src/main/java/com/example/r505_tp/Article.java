package com.example.r505_tp;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String date;
    private String contenu;

    private String nomAuteur;


    public Article(Utilisateur auteur) {
        this.auteur = auteur;
    }

    // Relation to utilisateur, many to one
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur auteur;

    public Article() {
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "like_article",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "utilisateur_id"))
    private java.util.List<Utilisateur> likes;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "dislike_article",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "utilisateur_id"))
    private java.util.List<Utilisateur> dislikes;

    public String getNomAuteur() {
        return nomAuteur;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }


    public void setDate() {
        java.util.Date date = new java.util.Date();
        this.date = new Date(date.getTime()).toString();
    }


    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getDate() {
        return date;
    }

    public String getContenu() {
        return contenu;
    }

    public java.util.List<Utilisateur> getLikes() {
        return likes;
    }

    public Long getId() {
        return id;
    }

    public List<Utilisateur> getDislikes() {
        return dislikes;
    }
}
