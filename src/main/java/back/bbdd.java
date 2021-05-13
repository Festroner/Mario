package back;

import java.sql.*;
import java.util.ArrayList;

public class bbdd {
    public static void main(String[] args) {
        Connection con;

        try {
            con = Conexion.dbConnector();
            String query = "select * from alerta";
            ResultSet rs = con.createStatement().executeQuery(query);

            while (rs.next()){
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("nombre"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //con.close();

    }

    public static class Conexion {


        public static Connection dbConnector() throws SQLException {

            String url = "jdbc:mysql://localhost/pastillas";
            Connection conn = DriverManager.getConnection(url, "root", "root");

            return conn;
        }

        public static int insertarAlerta(double cantidad, double cantidadDia, double tiempo, double duracion,String medicamento, String descripcion) {
            try {
                Connection con =  Conexion.dbConnector();
                String query ="INSERT INTO `alerta`(`id`, `cantidad`, `cantidadDia`, `tiempoTomas`, `duracion`, `medicamento`, `descripcion`) VALUES (NULL,'"+cantidad+"','"+cantidadDia+"','"+tiempo+"','"+duracion+"','"+medicamento+"','"+descripcion+"')";
                con.createStatement().executeQuery(query);
                con.close();



            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return 0;
        }

        public static int BorrarBbdd(int id) {
            try {
                Connection con =  Conexion.dbConnector();
                String query = "Delete from alerta where `id` = "+id;
                con.createStatement().executeQuery(query);
                con.close();


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return 0;
        }


        public static ArrayList<Pick> obtenerDatos() {

            ArrayList <Pick> lista = new ArrayList<>();

            try {

                Connection con =  Conexion.dbConnector();
                String query ="Select * from alerta";
                ResultSet rs =  con.createStatement().executeQuery(query);
                while (rs.next()){
                    Pick p = new Pick(rs.getString("descripcion"),rs.getString("medicamento"),rs.getInt("id"),rs.getDouble("dia"),rs.getDouble("cantidad"),rs.getDouble("tiempo"),rs.getInt("duracion"), rs.getInt("duracion"),rs.getDate("fechaini"), rs.getDate("fechafin"));

                    lista.add(p);
                }
                con.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return lista;
        }
    }
}
