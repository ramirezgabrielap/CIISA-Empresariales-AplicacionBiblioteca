package DAO;


public class DAOEditorial {
    
    private String _VCH_NOMBRE_EDITORIAL;
    private int _ID_EDITORIAL;

    
    
    public int getID_EDITORIAL() {
        return _ID_EDITORIAL;
    }

    public void setID_EDITORIAL(int _ID_EDITORIAL) {
        this._ID_EDITORIAL = _ID_EDITORIAL;
    }

    public String getVCH_NOMBRE_EDITORIAL(){
        return _VCH_NOMBRE_EDITORIAL;
    }

    public void setVCH_NOMBRE_EDITORIAL(String _VCH_NOMBRE_EDITORIAL) {
        this._VCH_NOMBRE_EDITORIAL = _VCH_NOMBRE_EDITORIAL;
    }
    
    
    public DAOEditorial() {
    }

    public DAOEditorial(int edit, String nom) {
        this._ID_EDITORIAL = edit;
        this._VCH_NOMBRE_EDITORIAL = nom;
    }
    
    // VALIDAMOS EL SETEO DE LAS VARIABLES:
    
    public Boolean ValidaSubida(String nom){
        Boolean flag = true;
        if (!nom.isEmpty()){
            setVCH_NOMBRE_EDITORIAL(nom);
        } else {
            return false;
        }
        return flag;
    }
    
    public Boolean ValidaSubida(int id, String nom){
	Boolean flag = true;
	if(id > 0){
            setID_EDITORIAL(id);
	} else {
		return false;
	}

	if(!nom.isEmpty()){
            setVCH_NOMBRE_EDITORIAL(nom);
	} else {
		return false;
	}
        return flag;
    }

    @Override
    public String toString() {
        return "DAOEditorial{" + "_VCH_NOMBRE_EDITORIAL=" + _VCH_NOMBRE_EDITORIAL + ", _ID_EDITORIAL=" + _ID_EDITORIAL + '}';
    }
    
    
}

