package com.example.r505_tp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @PostMapping("/ajouter")
    public @ResponseBody String ajouterUtilisateur(@RequestBody CreateUtilisateurCommande request) {
        String nom = request.getNom();
        String role = request.getRole();
        String password = request.getPassword();
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(nom);
        utilisateur.setRole(role);
        utilisateur.setPassword(password);
        utilisateurRepository.save(utilisateur);
        return "Utilisateur ajouté";
    }

    @GetMapping("/lister")
    public @ResponseBody Iterable<Utilisateur> listerUtilisateurs() {
        return utilisateurRepository.findAll();
    }

}
