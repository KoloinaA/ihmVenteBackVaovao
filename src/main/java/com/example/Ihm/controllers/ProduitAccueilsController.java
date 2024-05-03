package com.example.Ihm.controllers;

import com.example.Ihm.DB.ProduitAccueilDB;
import com.example.Ihm.DB.ProduitDB;
import com.example.Ihm.models.Produit;
import com.example.Ihm.models.ProduitAccueil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping(value="/produit")
public class ProduitAccueilsController {
    @GetMapping(value = "/produitAccueil")
    public List<ProduitAccueil> getProduit() throws SQLException {
        List<ProduitAccueil> produitAccueils=new ArrayList<>();
        ProduitAccueilDB produitAccueilDB=new ProduitAccueilDB();
        produitAccueils=produitAccueilDB.selectProduitAccueil();
        return produitAccueils;
    }
}
