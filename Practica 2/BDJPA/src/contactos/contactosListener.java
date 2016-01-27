package contactos;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class contactosListener
 *
 */
@WebListener
public class contactosListener implements ServletContextListener {

	  public void contextInitialized(ServletContextEvent e) {
	        com.objectdb.Enhancer.enhance("contactos.*");
	        EntityManagerFactory emf =Persistence.createEntityManagerFactory("$objectdb/db/contactos.odb");
	        e.getServletContext().setAttribute("emf", emf);
	    }
	 
	    // Release the EntityManagerFactory:
	    public void contextDestroyed(ServletContextEvent e) {
	        EntityManagerFactory emf =
	            (EntityManagerFactory)e.getServletContext().getAttribute("emf");
	        emf.close();
	    }
	
}
