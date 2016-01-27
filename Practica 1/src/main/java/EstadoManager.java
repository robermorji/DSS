
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "estadoManager", eager = true)
@SessionScoped
public class EstadoManager implements Serializable{
	private static final long serialVersionUID = 1L;	
	
	String colorAcelerar;
	String colorApagado;
	String colorEncendido;
	String colorEstado;
	
	String textoApagado;
	String textoAcelerar;
	String textoEncendido;
	String textoButtonOnOff;
	
	String estado;
	Acelerar acelerar;
	Apagar apagar;
	Encender encender;
	
	public EstadoManager(){
		colorAcelerar="blue";
		colorApagado="red";
		colorEncendido="green";
		
		textoApagado = "APAGADO";
		textoAcelerar = "ACELERANDO";
		textoEncendido = "ENCENDIDO";
		
		textoButtonOnOff = "ENCENDER";
		
		estado = "APAGADO";
		
		apagar = new Apagar();
		encender = new Encender();
		acelerar = new Acelerar();
		
		
	}

	public void setColorAcelerar(String color){
		colorAcelerar = color;
	}
	
	public void setColorApagado(String color){
		colorApagado = color;
	}
	
	public void setColorEncendido(String color){
		colorEncendido = color;
	}
	
	
	public String getColorAcelerar(){
		return colorAcelerar;
	}
	
	public String getColorApagado(){
		return colorApagado;
	}
	
	public String getColorEncendido(){
		return colorEncendido;
	}

	public void setTextoApagado(String texto){
		textoApagado = texto;
	}
	
	public String getTextoApagado(){
		return textoApagado;
	}
	
	public void setTextoAcelerar(String texto){
		textoAcelerar = texto;
	}
	
	public String getTextoAcelerar(){
		return textoAcelerar;
	}
	
	public void setTextoEncendido(String texto){
		textoEncendido = texto;
	}
	
	public String getTextoEncendido(){
		return textoEncendido;
	}
	
	public void setEstado(String estado){
		this.estado = estado;
	}
	
	public boolean getEstadoAcelerar(){
		return acelerar.getEstadoActivo();
	}
	
	public void setColorEstado(String coloro){
		this.colorEstado = estado;
	}
	
	public String getColorEstado(){
		return this.colorEstado;
	}
	
	public void ChangeStateBotonAcelerar(){
		if (encender.getEstadoActivo()==true){
			if (acelerar.getEstadoActivo()==false){
				acelerar.setChangeEstadoActivo();
				setEstado(getTextoAcelerar());
			}
			else{
				acelerar.setChangeEstadoInactivo();
				setEstado(getTextoEncendido());
			}
		}
	}
	
	public void ChangeStateBotonEncenderApagado(){
		
		if (encender.getEstadoActivo()==false){
			encender.setChangeEstadoActivo();
			setEstado(getTextoEncendido());
			setTextoButtonOnOff(getTextoApagado());
			
			
		}
		else{
			encender.setChangeEstadoInactivo();
			setEstado(getTextoApagado());
			setTextoButtonOnOff(getTextoEncendido());
		}
	}
	
	public String getEstado(){
		return estado;
	}
	
	public void setTextoButtonOnOff(String texto){
		textoButtonOnOff = texto;
	}
	
	public String getTextoButtonOnOff(){
		return textoButtonOnOff;
	}
	
	

}



