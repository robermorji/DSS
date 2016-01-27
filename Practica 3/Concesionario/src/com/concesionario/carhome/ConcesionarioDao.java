package com.concesionario.carhome;

import java.util.HashMap;

public enum ConcesionarioDao {
	instance;
	HashMap<String, Concesionario> contenido = new HashMap<>();
	
	private ConcesionarioDao(){
		Concesionario objetoConcesionario = new Concesionario("PEUGEOT","207 XSI V16","DIESEL",12000);
		contenido.put("1", objetoConcesionario);
		objetoConcesionario = new Concesionario("SEAT LEON","XSI","GASOLINA",10000);
		contenido.put("2", objetoConcesionario);
	}
	
	public HashMap<String, Concesionario> getModel(){
		return contenido;
	}
}
