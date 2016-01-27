package com.concesionario.carhome;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement

public class Concesionario {
	private String marca;
	private String modelo;
	private String tipoCarburante;
	private double precio;

	public Concesionario(){
		
	}
	public Concesionario(String modelo, String marca, String tipoCarburante, double precio){
		this.modelo = modelo;
		this.marca = marca;
		this.tipoCarburante = tipoCarburante;
		this.precio = precio;
	}
	public void setMarca(String marca){
		this.marca = marca;
	}
	
	public void setModelo(String modelo){
		this.modelo = modelo;
	}
	
	public void setTipoCarburante(String tipo_carburante){
		this.tipoCarburante = tipo_carburante;
	}
	
	public void setPrecio ( double precio){
		this.precio = precio;
	}
	
	public String getModelo(){
		return this.modelo;
	}
	
	public String getMarca(){
		return this.marca;
	}
	
	public String getTipoCarburante(){
		return this.tipoCarburante;
	}
	
	public double getPrecio(){
		return this.precio;
	}
	
}
