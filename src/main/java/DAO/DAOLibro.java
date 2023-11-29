package DAO;


public class DAOLibro {
    
    private int _ID_LIBRO;
    private String _VCH_NOMBRE_LIBRO;
    private int _INT_STOCK;
    private int _INT_CANT_ACT;
    private int _INT_RESTRICCION_EDAD;
    private String _VCH_RUT;
    private int _ID_EDITORIAL;
    private int _INT_CODIGO_ISBN;

   
         
    public int getID_LIBRO() {
        return _ID_LIBRO;
    }

    public void setID_LIBRO(int _ID_LIBRO) {
        this._ID_LIBRO = _ID_LIBRO;
    }

    public String getVCH_NOMBRE_LIBRO() {
        return _VCH_NOMBRE_LIBRO;
    }

    public void setVCH_NOMBRE_LIBRO(String _VCH_NOMBRE_LIBRO) {
        this._VCH_NOMBRE_LIBRO = _VCH_NOMBRE_LIBRO;
    }

    public int getINT_STOCK() {
        return _INT_STOCK;
    }

    public void setINT_STOCK(int _INT_STOCK) {
        this._INT_STOCK = _INT_STOCK;
    }

    public int getINT_CANT_ACT() {
        return _INT_CANT_ACT;
    }

    public void setINT_CANT_ACT(int _INT_CANT_ACT) {
        this._INT_CANT_ACT = _INT_CANT_ACT;
    }

    public int getINT_RESTRICCION_EDAD() {
        return _INT_RESTRICCION_EDAD;
    }

    public void setINT_RESTRICCION_EDAD(int _INT_RESTRICCION_EDAD) {
        this._INT_RESTRICCION_EDAD = _INT_RESTRICCION_EDAD;
    }

    public String getVCH_RUT() {
        return _VCH_RUT;
    }

    public void setVCH_RUT(String _VCH_RUT) {
        this._VCH_RUT = _VCH_RUT;
    }

    public int getINT_CODIGO_ISBN() {
        return _INT_CODIGO_ISBN;
    }

    public void setINT_CODIGO_ISBN(int _INT_CODIGO_ISBN) {
        this._INT_CODIGO_ISBN = _INT_CODIGO_ISBN;
    }

    public int getID_EDITORIAL() {
        return _ID_EDITORIAL;
    }

    public void setID_EDITORIAL(int _ID_EDITORIAL) {
        this._ID_EDITORIAL = _ID_EDITORIAL;
    }
    
    public DAOLibro() {
    }

    public DAOLibro(int _ID_LIBRO, String _VCH_NOMBRE_LIBRO, int _INT_STOCK, int _INT_CANT_ACT, int _INT_RESTRICCION_EDAD, String _VCH_RUT, int _INT_CODIGO_ISBN, int _ID_EDITORIAL) {
        this._ID_LIBRO = _ID_LIBRO;
        this._VCH_NOMBRE_LIBRO = _VCH_NOMBRE_LIBRO;
        this._INT_STOCK = _INT_STOCK;
        this._INT_CANT_ACT = _INT_CANT_ACT;
        this._INT_RESTRICCION_EDAD = _INT_RESTRICCION_EDAD;
        this._VCH_RUT = _VCH_RUT;
        this._INT_CODIGO_ISBN = _INT_CODIGO_ISBN;
        this._ID_EDITORIAL = _ID_EDITORIAL;
    }

    // VALIDAMOS EL SETEO DE LAS VARIABLES:
    
    public Boolean ValidaSubida(DAOLibro libro){
        if (libro.getVCH_NOMBRE_LIBRO().isEmpty()){
            return false;
        } 
        if (libro.getINT_STOCK() <= 0) {
            return false;
        }
        if (libro.getINT_CANT_ACT() <= 0){
            return false;
        }
        if (libro.getINT_RESTRICCION_EDAD() <= 0){
            return false;
        }
        if (libro.getID_EDITORIAL() <= 0){
            return false;
        }
        if (libro.getINT_CODIGO_ISBN() <=0) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "DAOLibro{" + "_ID_LIBRO=" + _ID_LIBRO + ", _VCH_NOMBRE_LIBRO=" + _VCH_NOMBRE_LIBRO + ", _INT_STOCK=" + _INT_STOCK + ", _INT_CANT_ACT=" + _INT_CANT_ACT + ", _INT_RESTRICCION_EDAD=" + _INT_RESTRICCION_EDAD + ", _VCH_RUT=" + _VCH_RUT + ", _ID_EDITORIAL=" + _ID_EDITORIAL + ", _INT_CODIGO_ISBN=" + _INT_CODIGO_ISBN + '}';
    }
    
}
