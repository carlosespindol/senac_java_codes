package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Golfinho;
import model.Jaula;

public class CadastrarGolfinho {
    public static void InsertGolfinho(Golfinho golfinho, Jaula jaula) {

        try {

            final String url = "jdbc:mysql://localhost:3306/zoo_bd?useTimezone=true&serverTimezone=UTC";
            final String user = "root";
            final String password = "";
            Connection con = DriverManager.getConnection(url, user, password);

            PreparedStatement pState = con.prepareStatement("INSERT INTO jaula ( descricao ) VALUES (?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pState.setString(1, jaula.getDescricao());

            if (pState.executeUpdate() > 0) {
                ResultSet rs = pState.getGeneratedKeys();
                rs.next();
                int idJaula = rs.getInt(1);

                PreparedStatement pGolfinho = con.prepareStatement(
                        "INSERT INTO golfinho (nome,treinamento,jaula_id) VALUES (?,?,?)",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                pGolfinho.setString(1, golfinho.getNome());
                pGolfinho.setInt(2, golfinho.getTreinamento());
                pGolfinho.setInt(3, idJaula);
                if (pGolfinho.executeUpdate() > 0) {
                    ResultSet rsGolfinho = pGolfinho.getGeneratedKeys();
                    rsGolfinho.next();
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
