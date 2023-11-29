package Model;


public class Conexion {
    
    private final String driver;
    private final String url;
    private final String usuario;
    private final String password;

    public Conexion() {
        this.driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // apunta al script del driver y modifica las dependencias del pom
        this.url = "jdbc:sqlserver://localhost\\DESKTOP-CKA2UIK:1433;databaseName=BCIISA;trustServerCertificate=true"; // se obtiene desde las propiedades de la BBDD en netbeans
        this.usuario = "sa";
        this.password = "gaba1313";
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    
}
