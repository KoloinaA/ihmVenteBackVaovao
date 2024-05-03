package com.example.Ihm.DB;

import com.example.Ihm.models.Fournisseur;
import com.example.Ihm.models.ProduitAccueil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitAccueilDB {
    public List<ProduitAccueil> selectProduitAccueil() throws SQLException {
        List<ProduitAccueil> produitAccueils=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        String sql="SELECT  p.idPro,p.idFr, p.design,p.descri,p.prix,p.categorie,p.nbClic,p.imgPro,p.qte,a.commentaire AS avis,a.vote,p.dateAjout as date FROM produit p LEFT JOIN avis a ON p.idPro = a.idPro";
        try( PreparedStatement statement= connection.prepareStatement(sql)){


            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                int idPro= resultSet.getInt("idPro");
                int idFr= resultSet.getInt("idFr");
                String design=resultSet.getString("design");
                String descri=resultSet.getString("descri");
                int prix=resultSet.getInt("prix");
                String categorie=resultSet.getString("categorie");
                int nbClic=resultSet.getInt("nbClic");
                byte[] imgPro=resultSet.getBytes("imgPro");
                int qte=resultSet.getInt("qte");
                String avis=resultSet.getString("avis");
                double vote=resultSet.getDouble("vote");
                String date=resultSet.getString("date");
                produitAccueils.add(new ProduitAccueil(idPro,idFr,design,descri,prix,categorie,nbClic,imgPro,qte,avis,vote,date));
            }
            resultSet.close();
            statement.close();
        }

        return produitAccueils;
    }
}
