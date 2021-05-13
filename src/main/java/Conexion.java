import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection dbConnector() throws SQLException {
        Connection conn = DriverManager.getConnection(bbdd.SERVER, bbdd.username,bbdd.password);
        return conn;
    }
}

