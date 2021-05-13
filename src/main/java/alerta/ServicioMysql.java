package alerta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
@Component
public class ServicioMysql {
    private static DriverManagerDataSource Conexion(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(BBDD.CLASSNAME);
        dataSource.setUrl(BBDD.URL);
        dataSource.setUsername(BBDD.USER);
        dataSource.setPassword(BBDD.PASSWORD);
        return dataSource;
    }

    public List<alerta> findAll() {
        DriverManagerDataSource dataSource = Conexion();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        return jdbcTemplate.query(
                "SELECT * FROM alerta",
                (rs, rowNum) -> new alerta(rs.getInt("id"),rs.getString("medicamento")
                        ,rs.getInt("cantidad"),rs.getInt("cantidadDia")
                        ,rs.getInt("tiempoTomas"),rs.getInt("duracion")
                        ,rs.getString("descripcion"),rs.getString("inicio")
                        ,rs.getString("fin"),rs.getInt("activo")));
    }
    public void insert(String nombre, int cantidad, int cantidadDia, int timepoTomas, int duracion, String descripcion, String inicio, String fin, int activo) {
        DriverManagerDataSource dataSource = Conexion();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("INSERT INTO alerta(id, cantidad, cantidadDia, tiempoTomas, duracion, " +
                "medicamento, descripcion, inicio, fin, activo) VALUES (NULL,"+cantidad+","+cantidadDia+","+timepoTomas+","+duracion+",'"+nombre+"','"+descripcion+"','"+inicio+"','"+fin+"',"+activo+")");
    }
    public void UPDATE(int activo, int id) {
        DriverManagerDataSource dataSource = Conexion();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("UPDATE `alerta` SET `activo`="+activo+" WHERE id ="+id+" ");
    }
    public int COUNTACTIVOS(){
        DriverManagerDataSource dataSource = Conexion();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM alerta where activo = 1",Integer.class);
    }
    public int COUNTDESACTIVOS(){
        DriverManagerDataSource dataSource = Conexion();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM alerta where activo = 0",Integer.class);
    }
    public void delete(int id) {
        DriverManagerDataSource dataSource = Conexion();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute( "DELETE FROM alerta WHERE id ="+id+" ");
    }
}
