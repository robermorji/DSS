<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,contactos.Contactos"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <title>JPA Guest Book Web Application Tutorial</title>
    </head>
 
    <body>
        
        <hr><ol> <%
            @SuppressWarnings("unchecked") 
        	List<Contactos> nombre = (List<Contactos>)request.getAttribute("name");
        	Iterator it = nombre.iterator();
        	
        	while(it.hasNext()){
        		   Object[] obj = (Object[]) it.next();
        		   String name = String.valueOf(obj[0]); 
        		   String correo = String.valueOf(obj[1]);
        	%>
        	<li> <%= name + "," +correo %> </li>
          <%} %>
        </ol><hr>
 
        <iframe src="http://www.objectdb.com/pw.html?web-eclipse"
            frameborder="0" scrolling="no" width="100%" height="30"> </iframe>
     </body>
 </html>