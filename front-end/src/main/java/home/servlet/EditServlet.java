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
import dto.Notes;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idNote = req.getParameter("idNote");
		Notes note = null;
		try {
			
			Client client = ClientBuilder.newClient();
			note = client.target("http://localhost:8080/back-end/api/notes/" + idNote).request("application/json").get(Notes.class);
			
		} catch(NotFoundException e) {
			System.out.println(e);
		}
		if(note != null) {
			req.setAttribute("note", note);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/edit.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
}
