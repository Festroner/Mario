import java.sql.SQLException;

public class main {
    public void main(String[] args){
        try {
            Conexion.dbConnector();
            System.out.println("Se ha hecho la conexión");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
