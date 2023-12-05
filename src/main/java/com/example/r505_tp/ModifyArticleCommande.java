package com.example.r505_tp;

public class ModifyArticleCommande {

        private String contenu;
        private String nomAuteur;
        private Long idArticle;

        public ModifyArticleCommande(String contenu, String nomAuteur, Long idArticle) {
            this.contenu = contenu;
            this.nomAuteur = nomAuteur;
            this.idArticle = idArticle;
        }

        public ModifyArticleCommande() {
        }

        public String getContenu() {
            return contenu;
        }


        public Long getIdArticle() {
            return idArticle;
        }


        public String getNomAuteur() {
            return nomAuteur;
        }
}
