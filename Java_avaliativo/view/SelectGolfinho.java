package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Jaula;
import model.Golfinho;

public class SelectGolfinho {
    public static void selectGolfinho(Golfinho golfinho, Jaula jaula) {
        try {
            final String url = "jdbc:mysql://localhost:3306/zoo_bd?useTimezone=true&serverTimezone=UTC";
            final String user = "root";
            final String password = "";
            Connection con = DriverManager.getConnection(url, user, password);

            PreparedStatement state4 = con.prepareStatement(
                    "SELECT * FROM golfinho l INNER JOIN jaula j ON l.jaula_id = j.id  ",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ResultSet result = state4.executeQuery();
            while (result.next()) {
                Golfinho golfinho2 = new Golfinho(
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getInt("treinamento"),
                        result.getInt("jaula_id"),
                        result.getString("descricao"));
                System.out.println(golfinho2);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
