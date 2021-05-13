package alerta;

public interface BBDD {
    public String CLASSNAME = "com.mysql.cj.jdbc.Driver";
    /*public String URL = "jdbc:mysql://localhost:3306/pastillas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public String USER = "root";
    public String PASSWORD ="root";*/
    public String URL = "jdbc:mysql://eu-cdbr-west-01.cleardb.com:3306/heroku_80d30f2c7cc7931?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public String USER = "ba7ccc78d4ef07";
    public String PASSWORD ="7e55da32";
}
