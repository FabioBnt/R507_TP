package com.example.r505_tp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/index")
public class MainController {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @PostMapping("/ajouter")
    public @ResponseBody String ajouterUtilisateur(@RequestParam String nom,
                                                   @RequestParam String email, @RequestParam String password) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(nom);
        utilisateur.setEmail(email);
        utilisateur.setPassword(password);
        utilisateurRepository.save(utilisateur);
        return "Utilisateur ajouté";
    }


}