package com.concesionario.carhome;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;


// Will map the resource to the URL todos
@Path("/concesionario")
public class ResourcesConcesionario {

  // Allows to insert contextual objects into the class,
  // e.g. ServletContext, Request, Response, UriInfo
  @Context
  UriInfo uriInfo;
  @Context
  Request request;

  // Return the list of todos for applications
  @GET
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public List<Concesionario> getTodos() {
   List<Concesionario> concesionario = new ArrayList<Concesionario>();
   concesionario.addAll(ConcesionarioDao.instance.getModel().values());
   return concesionario;
  }

  @GET
  @Path("modelo")
  @Produces(MediaType.TEXT_PLAIN)
  public String getCount() {
    int count = ConcesionarioDao.instance.getModel().size();
    return String.valueOf(count);
  }
  
  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public void newTodo(@FormParam("id") String id,
	  @FormParam("modelo") String modelo,
      @FormParam("marca") String marca,
      @FormParam("tipo_carburante") String tipo_carburante,
      @FormParam("precio") double precio,
      @Context HttpServletResponse servletResponse) throws IOException {
	  
	  Concesionario concesionario = new Concesionario(modelo, marca,tipo_carburante,precio);
	  System.out.println(modelo+" - "+marca+" - "+tipo_carburante+" - "+precio);
	 
	
	  if (modelo != null){
		  concesionario.setModelo(modelo);
	  }
	  
	  if (marca != null) {
	      concesionario.setMarca(marca);
	  }
	    
      if (tipo_carburante != null){
    	 concesionario.setTipoCarburante(tipo_carburante);
      }
	    
	    if ( precio != 0){
	    	concesionario.setPrecio(precio);
	    }
	    
	    ConcesionarioDao.instance.getModel().put(id, concesionario);
	 
	    servletResponse.sendRedirect("../concesionario/");
  }
  
  @DELETE
  @Produces(MediaType.TEXT_HTML)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public void deleteCoche(@FormParam("id") String id,
		  @Context HttpServletResponse servletResponse) throws IOException {
	  			ConcesionarioDao.instance.getModel().remove(id);
	  			servletResponse.sendRedirect("../rest/concesionario");
  }
		
  

}

