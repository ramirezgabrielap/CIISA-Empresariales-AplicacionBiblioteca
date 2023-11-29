package DAO;

public class DAOAutor {
   
    private String _VCH_NOMBRE_AUTOR;
    private int _ID_AUTOR;

    
    
    public String getVCH_NOMBRE_AUTOR() {
        return _VCH_NOMBRE_AUTOR;
    }

    public void setVCH_NOMBRE_AUTOR(String _VCH_NOMBRE_AUTOR) {
        this._VCH_NOMBRE_AUTOR = _VCH_NOMBRE_AUTOR;
    }

    public int getID_AUTOR() {
        return _ID_AUTOR;
    }

    public void setID_AUTOR(int _ID_AUTOR) {
        this._ID_AUTOR = _ID_AUTOR;
    }
    
    
    public DAOAutor(){
    }

    public DAOAutor(int autor, String nom) {
        this._ID_AUTOR = autor;
        this._VCH_NOMBRE_AUTOR = nom;   
    }
    
    // VALIDAMOS EL SETEO DE LAS VARIABLES:
    
    public Boolean ValidaSubida(String nom){
        Boolean flag = true;
        if (!nom.isEmpty()){
            setVCH_NOMBRE_AUTOR(nom);
        } else {
            return false;
        }
        return flag;
    }
    
    public Boolean ValidaSubida(int id, String nom){
	Boolean flag = true;
	if(id > 0){
            setID_AUTOR(id);
	} else {
		return false;
	}

	if(!nom.isEmpty()){
            setVCH_NOMBRE_AUTOR(nom);
	} else {
		return false;
	}
        return flag;
    }

    @Override
    public String toString() {
        return "DAOAutor{" + "_VCH_NOMBRE_AUTOR=" + _VCH_NOMBRE_AUTOR + ", _ID_AUTOR=" + _ID_AUTOR + '}';
    }
    
    
    
}
