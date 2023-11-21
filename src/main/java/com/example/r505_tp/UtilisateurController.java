package com.example.r505_tp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/index")
public class UtilisateurController {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @PostMapping("/ajouter")
    public @ResponseBody String ajouterUtilisateur(@RequestParam String nom,
                                                   @RequestParam String role, @RequestParam String password) {
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
