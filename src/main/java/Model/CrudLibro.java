package Model;


import DAO.DAOLibro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CrudLibro {
    
    Conexion conexion = new Conexion();
    
    public String Create(Object obj) throws SQLException{
        DAOLibro libro = (DAOLibro) obj;
        Connection connection;
        PreparedStatement pst;
        String query = "INSERT INTO TBL_LIBRO VALUES (?,?,?,?,?,?,?)";
        String respuesta;    
        
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
            pst = (PreparedStatement) connection.prepareStatement(query);
            pst.setString(1, libro.getVCH_NOMBRE_LIBRO());
            pst.setInt(2, libro.getINT_STOCK());
            pst.setInt(3, libro.getINT_CANT_ACT());
            pst.setInt(4, libro.getINT_RESTRICCION_EDAD());
            pst.setString(5, libro.getVCH_RUT());
            pst.setInt(6, libro.getID_EDITORIAL());
            pst.setInt(7, libro.getINT_CODIGO_ISBN());
            
            respuesta = Integer.toString(pst.executeUpdate());
        } catch (ClassNotFoundException | SQLException ex) {
            respuesta = ex.getMessage();
        }        
        return respuesta;  
    }
    
    public List<DAOLibro> Read_Search(String parametro){
        Connection connection;
        PreparedStatement pst;
        String query = "SELECT * FROM TBL_LIBRO WHERE VCH_NOMBRE_LIBRO LIKE '%"+parametro+"%'";
        ResultSet rs;
        
        List<DAOLibro> listaLibro = new ArrayList<>();
        
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
            pst = connection.prepareStatement(query);
            rs= pst.executeQuery();
            
            while(rs.next()){
                DAOLibro Libro = new DAOLibro();
                Libro.setID_LIBRO(rs.getInt("ID_LIBRO"));
                Libro.setVCH_NOMBRE_LIBRO(rs.getString("VCH_NOMBRE_LIBRO"));
                Libro.setINT_STOCK(rs.getInt("INT_STOCK"));
                Libro.setINT_CANT_ACT(rs.getInt("INT_CANT_ACT"));
                Libro.setINT_RESTRICCION_EDAD(rs.getInt("INT_RESTRICCION_EDAD"));
                Libro.setVCH_RUT(rs.getString("VCH_RUT"));
                Libro.setID_EDITORIAL(rs.getInt("ID_EDITORIAL"));
                Libro.setINT_CODIGO_ISBN(rs.getInt("INT_CODIGO_ISBN"));
                listaLibro.add(Libro);
            }
            rs.close();
        }
        catch(SQLException | ClassNotFoundException ex){
            ex.getMessage();
        }
        return listaLibro;
    }
    
    public List<DAOLibro> Read_Search_IDEditorial(int ideditorial){
        Connection connection;
        PreparedStatement pst;
        String query = "SELECT * FROM TBL_LIBRO WHERE ID_EDITORIAL = "+ideditorial;
        ResultSet rs;
        
        List<DAOLibro> listaLibro = new ArrayList<>();
        
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
            pst = connection.prepareStatement(query);
            rs= pst.executeQuery();
            
            while(rs.next()){
                DAOLibro Libro = new DAOLibro();
                Libro.setID_LIBRO(rs.getInt("ID_LIBRO"));
                Libro.setVCH_NOMBRE_LIBRO(rs.getString("VCH_NOMBRE_LIBRO"));
                Libro.setINT_STOCK(rs.getInt("INT_STOCK"));
                Libro.setINT_CANT_ACT(rs.getInt("INT_CANT_ACT"));
                Libro.setINT_RESTRICCION_EDAD(rs.getInt("INT_RESTRICCION_EDAD"));
                Libro.setVCH_RUT(rs.getString("VCH_RUT"));
                Libro.setID_EDITORIAL(rs.getInt("ID_EDITORIAL"));
                Libro.setINT_CODIGO_ISBN(rs.getInt("INT_CODIGO_ISBN"));
                listaLibro.add(Libro);
            }
            rs.close();
        }
        catch(SQLException | ClassNotFoundException ex){
            ex.getMessage();
        }
        return listaLibro;
    }
    
    public List<DAOLibro> Read_Search_IDAutor(int idautor){
        Connection connection;
        PreparedStatement pst;
        String query = "SELECT L.* FROM TBL_LIBRO L, TBL_LIBRO_AUTOR LA, TBL_AUTORES A " +
                        "WHERE L.ID_LIBRO = LA.ID_LIBRO AND LA.ID_AUTOR = A.ID_AUTOR " +
                        "AND A.ID_AUTOR = "+idautor;
        ResultSet rs;
        
        List<DAOLibro> listaLibro = new ArrayList<>();
        
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
            pst = connection.prepareStatement(query);
            rs= pst.executeQuery();
            
            while(rs.next()){
                DAOLibro Libro = new DAOLibro();
                Libro.setID_LIBRO(rs.getInt("ID_LIBRO"));
                Libro.setVCH_NOMBRE_LIBRO(rs.getString("VCH_NOMBRE_LIBRO"));
                Libro.setINT_STOCK(rs.getInt("INT_STOCK"));
                Libro.setINT_CANT_ACT(rs.getInt("INT_CANT_ACT"));
                Libro.setINT_RESTRICCION_EDAD(rs.getInt("INT_RESTRICCION_EDAD"));
                Libro.setVCH_RUT(rs.getString("VCH_RUT"));
                Libro.setID_EDITORIAL(rs.getInt("ID_EDITORIAL"));
                Libro.setINT_CODIGO_ISBN(rs.getInt("INT_CODIGO_ISBN"));
                listaLibro.add(Libro);
            }
            rs.close();
        }
        catch(SQLException | ClassNotFoundException ex){
            ex.getMessage();
        }
        return listaLibro;
    }
    
    
    public List<DAOLibro> Lista(){
        Connection connection;
        PreparedStatement pst;
        String query = "SELECT * FROM TBL_LIBRO";
        ResultSet rs;
        
        List<DAOLibro> listaLibro = new ArrayList<>();
        
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
            pst = connection.prepareStatement(query);
            rs= pst.executeQuery();
            
            while(rs.next()){
                DAOLibro Libro = new DAOLibro();
                Libro.setID_LIBRO(rs.getInt("ID_LIBRO"));
                Libro.setVCH_NOMBRE_LIBRO(rs.getString("VCH_NOMBRE_LIBRO"));
                Libro.setINT_STOCK(rs.getInt("INT_STOCK"));
                Libro.setINT_CANT_ACT(rs.getInt("INT_CANT_ACT"));
                Libro.setINT_RESTRICCION_EDAD(rs.getInt("INT_RESTRICCION_EDAD"));
                Libro.setVCH_RUT(rs.getString("VCH_RUT"));
                Libro.setID_EDITORIAL(rs.getInt("ID_EDITORIAL"));
                Libro.setINT_CODIGO_ISBN(rs.getInt("INT_CODIGO_ISBN"));
                listaLibro.add(Libro);
            }
            rs.close();
        }
        catch(SQLException | ClassNotFoundException ex){
            ex.getMessage();
        }
        return listaLibro;
    }
    
    public DAOLibro Read_libro(int id){
        DAOLibro libro = new DAOLibro();
        Connection connection;
        PreparedStatement pst;
        String query = "SELECT * FROM TBL_LIBRO WHERE ID_LIBRO ='"+id+"'";
        ResultSet rs;
        
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
            pst = connection.prepareStatement(query);
            rs= pst.executeQuery();
            
            while(rs.next()){                
                libro.setID_LIBRO(rs.getInt("ID_LIBRO"));
                libro.setVCH_NOMBRE_LIBRO(rs.getString("VCH_NOMBRE_LIBRO"));
                libro.setINT_STOCK(rs.getInt("INT_STOCK"));
                libro.setINT_CANT_ACT(rs.getInt("INT_CANT_ACT"));
                libro.setINT_RESTRICCION_EDAD(rs.getInt("INT_RESTRICCION_EDAD"));
                libro.setVCH_RUT(rs.getString("VCH_RUT"));
                libro.setID_EDITORIAL(rs.getInt("ID_EDITORIAL"));
                libro.setINT_CODIGO_ISBN(rs.getInt("INT_CODIGO_ISBN"));
            }
            rs.close();
        }
        catch(SQLException | ClassNotFoundException ex){
            ex.getMessage();
        }
        return libro;
    }
    
    
    public DAOLibro Read_libro_isbn(int isbn){
        DAOLibro libro = new DAOLibro();
        Connection connection;
        PreparedStatement pst;
        String query = "SELECT * FROM TBL_LIBRO WHERE INT_CODIGO_ISBN ="+isbn;
        ResultSet rs;
        
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
            pst = connection.prepareStatement(query);
            rs= pst.executeQuery();
            
            while(rs.next()){                
                libro.setID_LIBRO(rs.getInt("ID_LIBRO"));
                libro.setVCH_NOMBRE_LIBRO(rs.getString("VCH_NOMBRE_LIBRO"));
                libro.setINT_STOCK(rs.getInt("INT_STOCK"));
                libro.setINT_CANT_ACT(rs.getInt("INT_CANT_ACT"));
                libro.setINT_RESTRICCION_EDAD(rs.getInt("INT_RESTRICCION_EDAD"));
                libro.setVCH_RUT(rs.getString("VCH_RUT"));
                libro.setID_EDITORIAL(rs.getInt("ID_EDITORIAL"));
                libro.setINT_CODIGO_ISBN(rs.getInt("INT_CODIGO_ISBN"));
            }
            rs.close();
        }
        catch(SQLException | ClassNotFoundException ex){
            ex.getMessage();
        }
        return libro;
    }
    
    public String Delete (Object obj){
        int id_libro = (int)obj;
        Connection connection;
        PreparedStatement pst;
        String query ="DELETE FROM TBL_LIBRO WHERE ID_LIBRO= "+id_libro;
        String respuesta;
        
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
            pst = connection.prepareStatement(query);
            pst.executeUpdate();
            respuesta="Libro eliminado con exito";
            
        }
        catch(SQLException | ClassNotFoundException ex){
            respuesta=ex.getMessage();
        }
        return respuesta;
    }
    
    public String DeleteAutorLibro (int idlibro){
        Connection connection;
        PreparedStatement pst;
        String query ="DELETE FROM TBL_LIBRO_AUTOR WHERE ID_LIBRO= "+idlibro;
        String respuesta;
        
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPassword());
            pst = connection.prepareStatement(query);
            pst.executeUpdate();
            respuesta="Libro eliminado con exito";
            
        }
        catch(SQLException | ClassNotFoundException ex){
            respuesta=ex.getMessage();
        }
        return respuesta;
    }
        
    public String Update(Object obj){
	DAOLibro libro = (DAOLibro) obj;
	Connection connection;
	PreparedStatement pst;
	String query = "UPDATE TBL_LIBRO SET " 
                + "VCH_NOMBRE_LIBRO = '"+ libro.getVCH_NOMBRE_LIBRO() + "', "
                + "INT_STOCK =" + libro.getINT_STOCK() +", "
                + "INT_CANT_ACT =" + libro.getINT_CANT_ACT() +", "
                + "INT_RESTRICCION_EDAD =" + libro.getINT_RESTRICCION_EDAD() +", "
                + "ID_EDITORIAL =" + libro.getID_EDITORIAL() +", "
                + "INT_CODIGO_ISBN =" + libro.getINT_CODIGO_ISBN()
                +" WHERE ID_LIBRO = " + libro.getID_LIBRO();
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
