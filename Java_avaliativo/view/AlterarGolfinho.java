package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Jaula;
import model.Golfinho;

public class AlterarGolfinho {
    public static void UpdateGolfinho(Golfinho golfinho, Jaula jaula) {

        try {

            final String url = "jdbc:mysql://localhost:3306/zoo_bd?useTimezone=true&serverTimezone=UTC";
            final String user = "root";
            final String password = "";
            Connection con = DriverManager.getConnection(url, user, password);

            PreparedStatement pGolfinho = con.prepareStatement(
                    "UPDATE golfinho SET nome = ?, treinamento = ?  WHERE id = ?",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pGolfinho.setString(1, golfinho.getNome());
            pGolfinho.setInt(2, golfinho.getTreinamento());
            pGolfinho.setInt(3, golfinho.getId());
            if (pGolfinho.executeUpdate() > 0) {
                ResultSet resultado = pGolfinho.getGeneratedKeys();

                if (resultado.next()) {
                    resultado.getString(1);
                    resultado.getInt(2);
                    resultado.getInt(3);
                }

            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
