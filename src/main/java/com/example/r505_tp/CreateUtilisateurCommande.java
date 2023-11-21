package com.example.r505_tp;

public class CreateUtilisateurCommande {

    private String nom;
    private String role;
    private String password;

    public CreateUtilisateurCommande(String nom, String role, String password) {
        this.nom = nom;
        this.role = role;
        this.password = password;
    }

    public CreateUtilisateurCommande() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
