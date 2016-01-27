package com.concesionario.carhome;
import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class ClienteConcesionario {

  public static void main(String[] args) {
    ClientConfig config = new ClientConfig();
    Client client = ClientBuilder.newClient(config);

    
    WebTarget target = client.target(getBaseURI());
    System.out.println(target);
    System.exit(0);
    // Get XML
    String xmlResponse = target.path("rest").path("concesionario").request()
        .accept(MediaType.TEXT_XML).get(String.class);
    // Get XML for application
    String xmlAppResponse =target.path("rest").path("concesionario").request()
        .accept(MediaType.APPLICATION_XML).get(String.class);
    
    String xmlDeleteAppResponse = target.path("rest").path("concesionario").request()
    	.accept(MediaType.APPLICATION_XML).delete(String.class);
    
   /* String xmlPutAppResponse = target.path("rest").path("concesionario").request()
    	.accept(MediaType.APPLICATION_XML).put(String.class);*/
    
    System.out.println(xmlResponse);
    System.out.println(xmlAppResponse);
  }

  private static URI getBaseURI() {
    return UriBuilder.fromUri("http://localhost:8080/Concesionario/rest/concesionario").build();
  }

} 
