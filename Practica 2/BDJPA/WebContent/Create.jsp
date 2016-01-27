<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,contactos.Contactos"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Correo</title>
</head>
<body>
<form method="POST" action="contactServlet">
            Name: <input type="text" name="name" />
            Correo: <input type="text" name="correo" />
            <input type="hidden" name="tipoConsulta" value="create" />
            <input type="submit" value="Add" />
        </form>
 
        <iframe src="http://www.objectdb.com/pw.html?web-eclipse"
            frameborder="0" scrolling="no" width="100%" height="30"> </iframe>
</body>
</html>