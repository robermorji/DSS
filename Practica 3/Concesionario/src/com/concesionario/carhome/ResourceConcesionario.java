package com.concesionario.carhome;

import javax.management.RuntimeErrorException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;


public class ResourceConcesionario {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	String id;
	
	public ResourceConcesionario(UriInfo uri, Request request, String id) {
		// TODO Auto-generated constructor stub
		this.uriInfo=uri;
		this.request = request;
		this.id = id;
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	
	public Concesionario getXML(){
		Concesionario concesionario = ConcesionarioDao.instance.getModel().get(this.id);
		if (concesionario == null) 
			throw new RuntimeException("Not found");
		
		return concesionario;
	}
	
	
	
	@GET
	@Produces({ MediaType.TEXT_XML })
	
	public Concesionario getHTML(){
		Concesionario concesionario = ConcesionarioDao.instance.getModel().get(id);
		
		if (concesionario == null) 
			throw new RuntimeException("Not found");
		
		return concesionario;
		
			
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	
	public Response putConcesionario(JAXBElement<Concesionario> concesionario) {
	    Concesionario objeto_concesionario = concesionario.getValue();
	    return putAndGetResponse(objeto_concesionario);
	}
	  
	@DELETE
	public void deleteTodo() {
	   Concesionario concesionario = ConcesionarioDao.instance.getModel().remove("id");
	    if(concesionario==null)
	      throw new RuntimeException("Delete: Todo with " + id +  " not found");
	  }
	
	
	@DELETE
	public void deleteElement(String id){
		Concesionario concesionario = ConcesionarioDao.instance.getModel().remove(id);
	    if(concesionario==null)
	      throw new RuntimeException("Delete: Todo with " + id +  " not found");
	}
	  
	  private Response putAndGetResponse(Concesionario concesionario) {
	    Response res;
	    if(ConcesionarioDao.instance.getModel().containsKey(concesionario.getModelo())) {
	      res = Response.noContent().build();
	    } else {
	      res = Response.created(uriInfo.getAbsolutePath()).build();
	    }
	    ConcesionarioDao.instance.getModel().put(concesionario.getModelo(), concesionario);
	    return res;
	  }
	  
	
}
