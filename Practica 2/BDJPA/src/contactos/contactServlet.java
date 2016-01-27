package contactos;

import java.io.IOException;
import java.util.List;

import javax.jdo.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;

/**
 * Servlet implementation class contactServlet
 */
@WebServlet("/contactServlet")
public class contactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(
	        HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 
	        // Obtain a database connection:
	        EntityManagerFactory emf =
	           (EntityManagerFactory)getServletContext().getAttribute("emf");
	        EntityManager em = emf.createEntityManager();
	       
	        try {
	            // Handle a new guest (if any):
	            String name = request.getParameter("name");
	            String tipoConsulta = request.getParameter("tipoConsulta");
	           
	           
	            // Display the list of guests:
	            if (tipoConsulta.equals("create")){
	            	System.out.println(tipoConsulta);
		            String correo = request.getParameter("correo");
		            if (name != null) {
		                em.getTransaction().begin();
		                em.persist(new Contactos(name,correo));
		                em.getTransaction().commit();
		            }
		            mostrarDispatcher(request, response, em);
		        }
	            else if (tipoConsulta.equals("delete")){
	            	em.getTransaction().begin();
	            	javax.persistence.Query row  = em.createQuery("DELETE FROM Contactos where name== :nombre", Contactos.class);
	            	int deletedCount = row.setParameter("nombre",name ).executeUpdate();
	            	em.getTransaction().commit();
	            	mostrarDispatcher(request, response, em);
	            }
	            else if (tipoConsulta.equals("read")){
	            	List<Contactos> row = em.createQuery("SELECT name,correo FROM Contactos WHERE name== :nombre", Contactos.class)
	            			.setParameter("nombre", name).getResultList();
	            	
	            	request.setAttribute("name", row);
	 		        request.getRequestDispatcher("/ListaCorreo.jsp")
	                 .forward(request, response);
	            	
	            }
	           
	        } finally {
	            // Close the database connection:
	            if (em.getTransaction().isActive())
	                em.getTransaction().rollback();
	            em.close();
	        }
	    }
	 
	    @Override
	    protected void doPost(
	        HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }
	    
	    public void mostrarDispatcher(HttpServletRequest request, HttpServletResponse response, EntityManager em){
	    	List<Contactos> contactoList = em.createQuery(
	                "SELECT name,correo FROM Contactos", Contactos.class).getResultList();
	        request.setAttribute("name", contactoList);
	        try {
				request.getRequestDispatcher("/ListaCorreo.jsp")
				.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}
