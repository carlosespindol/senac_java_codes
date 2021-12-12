package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Jaula;
import model.Golfinho;

public class DeletaGolfinho {
    public static void deletaGolfinho(Golfinho golfinho, Jaula jaula) {

        try {

            final String url = "jdbc:mysql://localhost:3306/zoo_bd?useTimezone=true&serverTimezone=UTC";
            final String user = "root";
            final String password = "";
            Connection con = DriverManager.getConnection(url, user, password);

            PreparedStatement pGolfinho = con.prepareStatement("DELETE FROM golfinho WHERE id = ? ",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pGolfinho.setInt(1, golfinho.getId());

            if (pGolfinho.executeUpdate() > 0) {
                ResultSet resultado = pGolfinho.getGeneratedKeys();

                if (resultado.next()) {
                    resultado.getInt(1);
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
