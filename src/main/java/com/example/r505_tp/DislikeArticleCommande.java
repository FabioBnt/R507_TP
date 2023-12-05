package com.example.r505_tp;

public class DislikeArticleCommande {

        private Long idArticle;
        private Long idUtilisateur;

        public DislikeArticleCommande(Long idArticle, Long idUtilisateur) {
            this.idArticle = idArticle;
            this.idUtilisateur = idUtilisateur;
        }

        public DislikeArticleCommande() {
        }

        public Long getIdArticle() {
            return idArticle;
        }

        public void setIdArticle(Long idArticle) {
            this.idArticle= idArticle;
        }

        public Long getIdUtilisateur() {
            return idUtilisateur;
        }

        public void setIdUtilisateur(Long idUtilisateur) {
            this.idUtilisateur= idUtilisateur;
        }
}
