
public class Encender implements Estado{

	public boolean estadoActivo;
	public boolean estadoInactivo;

	
	public Encender(){
		estadoActivo = false;
		estadoInactivo = true;
	}
	
	
	public boolean getEstadoActivo() {
		// TODO Auto-generated method stub
		return this.estadoActivo;
	}
	
	public boolean getEstadoInactivo() {
		// TODO Auto-generated method stub
		return this.estadoInactivo;
	}

	public void setChangeEstadoActivo() {
		// TODO Auto-generated method stub
		this.estadoActivo = true;
		this.estadoInactivo = false;
		
	}
	
	public void setChangeEstadoInactivo() {
		// TODO Auto-generated method stub
		this.estadoInactivo = true;
		this.estadoActivo = false;
		
	}

}
