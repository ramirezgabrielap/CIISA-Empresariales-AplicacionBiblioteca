package Model;

import DAO.DAOEditorial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CrudEditorial {
    
    Conexion conexion = new Conexion();
    
    public String Create(Object obj) throws SQLException{
        DAOEditorial editorial = (DAOEditorial) obj;
        Connection connection;
        PreparedStatement pst;
        String query = "INSERT INTO TBL_EDITORIAL VALUES (?)";
        String respuesta;    
        
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
            pst = (PreparedStatement) connection.prepareStatement(query);
            pst.setString(1, editorial.getVCH_NOMBRE_EDITORIAL());
            respuesta = Integer.toString(pst.executeUpdate());
        } catch (ClassNotFoundException | SQLException ex) {
            respuesta = ex.getMessage();
        }        
        return respuesta;  
    }

    public List<DAOEditorial> Read_Search(String parametro){
        Connection connection;
        PreparedStatement pst;
        String query = "SELECT * FROM TBL_EDITORIAL WHERE VCH_NOMBRE_EDITORIAL LIKE '%"+parametro+"%'";
        ResultSet rs;
        
        List<DAOEditorial> listaEditorial = new ArrayList<>();
        
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
            pst = connection.prepareStatement(query);
            rs= pst.executeQuery();
            
            while(rs.next()){
                DAOEditorial Editorial = new DAOEditorial();
                Editorial.setID_EDITORIAL(rs.getInt("ID_EDITORIAL"));
                Editorial.setVCH_NOMBRE_EDITORIAL(rs.getString("VCH_NOMBRE_EDITORIAL"));
                listaEditorial.add(Editorial);
            }
            rs.close();
        }
        catch(SQLException | ClassNotFoundException ex){
            ex.getMessage();
        }
        return listaEditorial;
    }
    
    public DAOEditorial Read_editorial(Integer ideditorial){
        Connection connection;
        PreparedStatement pst;
        String query = "SELECT * FROM TBL_EDITORIAL WHERE ID_EDITORIAL =" +ideditorial;
        ResultSet rs;
        
        DAOEditorial editorial = new DAOEditorial();
        
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
            pst = connection.prepareStatement(query);
            rs= pst.executeQuery();
            
            while(rs.next()){
                editorial.setID_EDITORIAL(rs.getInt("ID_EDITORIAL"));
                editorial.setVCH_NOMBRE_EDITORIAL(rs.getString("VCH_NOMBRE_EDITORIAL"));
            }
            rs.close();
        }
        catch(SQLException | ClassNotFoundException ex){
            ex.getMessage();
        }
        return editorial;
    }
     
    public List<DAOEditorial> Lista_editorial(){
        Connection connection;
        PreparedStatement pst;
        String query = "SELECT * FROM TBL_EDITORIAL";
        ResultSet rs;
        
        List<DAOEditorial> listaEditorial = new ArrayList<>();
        
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
            pst = connection.prepareStatement(query);
            rs= pst.executeQuery();
            
            while(rs.next()){
                DAOEditorial Editorial = new DAOEditorial();
                Editorial.setID_EDITORIAL(rs.getInt("ID_EDITORIAL"));
                Editorial.setVCH_NOMBRE_EDITORIAL(rs.getString("VCH_NOMBRE_EDITORIAL"));
                listaEditorial.add(Editorial);
            }
            rs.close();
        }
        catch(SQLException | ClassNotFoundException ex){
            ex.getMessage();
        }
        return listaEditorial;
    }
    

    public String Delete (Object obj){
        int id_editorial = (int)obj;
        Connection connection;
        PreparedStatement pst;
        String query ="DELETE FROM TBL_EDITORIAL WHERE ID_EDITORIAL= '"+id_editorial+"'";
        String respuesta;
        
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
            pst = connection.prepareStatement(query);
            pst.executeUpdate();
            respuesta="Editorial eliminada con exito";
            
        }
        catch(SQLException | ClassNotFoundException ex){
            respuesta=ex.getMessage();
        }
        return respuesta;
    }
    
    public String Update(Object obj){
	DAOEditorial editorial = (DAOEditorial) obj;
	Connection connection;
	PreparedStatement pst;
	String query = "UPDATE TBL_EDITORIAL SET VCH_NOMBRE_EDITORIAL = '"+ editorial.getVCH_NOMBRE_EDITORIAL() + "'WHERE ID_EDITORIAL = '" + editorial.getID_EDITORIAL()+"'";
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

