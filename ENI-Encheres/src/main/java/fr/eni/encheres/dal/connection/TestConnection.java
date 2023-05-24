package fr.eni.encheres.dal.connection;

import java.sql.Connection;
import java.sql.SQLException;

import fr.eni.encheres.exceptions.ExceptionTechnique;

public class TestConnection {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = ConnectionProvider.connection();
            if (connection != null) {
                System.out.println("Connexion réussie !");
                // Effectuer des opérations sur la base de données ici
                // Par exemple, exécuter une requête SELECT
                // ou insérer des données dans une table
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        } catch (ExceptionTechnique e) {
            System.out.println("Erreur technique : " + e.getMessage());
        } finally {
            // Fermer la connexion une fois les opérations terminées
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
                }
            }
        }
    }
}
