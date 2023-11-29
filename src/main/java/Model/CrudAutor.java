package Model;

import DAO.DAOAutor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CrudAutor {
    
    Conexion conexion = new Conexion();
    
    public String Create(Object obj) throws SQLException{
        DAOAutor autor = (DAOAutor) obj;
        Connection connection;
        PreparedStatement pst;
        String query = "INSERT INTO TBL_AUTORES VALUES (?)";
        String respuesta;    
        
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
            pst = (PreparedStatement) connection.prepareStatement(query);
            pst.setString(1, autor.getVCH_NOMBRE_AUTOR());
            respuesta = Integer.toString(pst.executeUpdate());
        } catch (ClassNotFoundException | SQLException ex) {
            respuesta = ex.getMessage();
        }        
        return respuesta;  
    }
    
    public List<DAOAutor> Read_Search(String parametro){
        Connection connection;
        PreparedStatement pst;
        String query = "SELECT * FROM TBL_AUTORES WHERE VCH_NOMBRE_AUTOR LIKE '%"+parametro+"%'";
        ResultSet rs;
        
        List<DAOAutor> listaAutor = new ArrayList<>();
        
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
            pst = connection.prepareStatement(query);
            rs= pst.executeQuery();
            
            while(rs.next()){
                DAOAutor Autor = new DAOAutor();
                Autor.setID_AUTOR(rs.getInt("ID_AUTOR"));
                Autor.setVCH_NOMBRE_AUTOR(rs.getString("VCH_NOMBRE_AUTOR"));
                listaAutor.add(Autor);
            }
            rs.close();
        }
        catch(SQLException | ClassNotFoundException ex){
            ex.getMessage();
        }
        return listaAutor;
    }
    
    public DAOAutor Read_autor(Integer idautor){
        Connection connection;
        PreparedStatement pst;
        String query = "SELECT * FROM TBL_AUTORES WHERE ID_AUTOR =" +idautor;
        ResultSet rs;
        
        DAOAutor autor = new DAOAutor();
        
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
            pst = connection.prepareStatement(query);
            rs= pst.executeQuery();
            
            while(rs.next()){
                autor.setID_AUTOR(rs.getInt("ID_AUTOR"));
                autor.setVCH_NOMBRE_AUTOR(rs.getString("VCH_NOMBRE_AUTOR"));
            }
            rs.close();
        }
        catch(SQLException | ClassNotFoundException ex){
            ex.getMessage();
        }
        return autor;
    }
    
    public List<DAOAutor> Lista_autor(){
        Connection connection;
        PreparedStatement pst;
        String query = "SELECT * FROM TBL_AUTORES";
        ResultSet rs;
        
        List<DAOAutor> listaAutor = new ArrayList<>();
        
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
            pst = connection.prepareStatement(query);
            rs= pst.executeQuery();
            
            while(rs.next()){
                DAOAutor autor = new DAOAutor();
                autor.setID_AUTOR(rs.getInt("ID_AUTOR"));
                autor.setVCH_NOMBRE_AUTOR(rs.getString("VCH_NOMBRE_AUTOR"));
                listaAutor.add(autor);
            }
            rs.close();
        }
        catch(SQLException | ClassNotFoundException ex){
            ex.getMessage();
        }
        return listaAutor;
    }
    
    public String Delete (Object obj){
        int id_autor = (int)obj;
        Connection connection;
        PreparedStatement pst;
        String query ="DELETE FROM TBL_AUTORES WHERE ID_AUTOR= '"+id_autor+"'";
        String respuesta;
        
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
            pst = connection.prepareStatement(query);
            pst.executeUpdate();
            respuesta="Autor eliminado con exito";
            
        }
        catch(SQLException | ClassNotFoundException ex){
            respuesta=ex.getMessage();
        }
        return respuesta;
    }
    
    public String Update(Object obj){
	DAOAutor autor = (DAOAutor) obj;
	Connection connection;
	PreparedStatement pst;
	String query = "UPDATE TBL_AUTORES SET VCH_NOMBRE_AUTOR = '"+ autor.getVCH_NOMBRE_AUTOR() + "'WHERE ID_AUTOR = '" + autor.getID_AUTOR()+"'";
	String respuesta;

	try {
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
            pst = (PreparedStatement) connection.prepareStatement(query);
            respuesta = Integer.toString(pst.executeUpdate());
	} catch(ClassNotFoundException | SQLException ex){
            respuesta = ex.getMessage();
	}
	return respuesta;
    }
    
}
