package home.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDelete(request,response);
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idNote = request.getParameter("idNote");

		try {
			Client client = ClientBuilder.newClient();
			Response resp = client.target("http://localhost:8080/back-end/api/notes/" + idNote).request("application/json").delete();
		    
		    if (resp != null) {
		    	request.setAttribute("resp", resp);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home");
				dispatcher.forward(request, response);
			}
		    
		} catch(NotFoundException e) {
			System.out.println("The note can't be deleted.");
		}
	}
}
