package contactos;


import java.io.Serializable;
import java.sql.Date;
import java.util.Iterator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contactos {
	   private static final long serialVersionUID = 1L;
	   
	    // Persistent Fields:
	    @Id @GeneratedValue
	    Long id;
	    private String name;
	    private String correo;
	    
	 // Constructors:
	    public Contactos() {
	    }
	 
	    public Contactos(String name,String correo) {
	        this.name= name;
	        this.correo = correo;
	    }
	 
	    // String Representation:
	    @Override
	    public String toString() {
	        return name;
	    }
	    
	    public String getCorreo(){
	    	return this.correo;
	    }
	    
	    public String getName(){
	    	return this.name;
	    }
	    
	   
}
