package home.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import dto.Notes;

@WebServlet("/add")
public class AddNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UUID idUser =  (UUID) session.getAttribute("idUser");
		
		String name = request.getParameter("name");
		String content = request.getParameter("content");
	
		Notes note = new Notes();
		note.setNameNote(name);
		note.setContent(content);
		note.setIdUser(idUser);
		
		Client client = ClientBuilder.newClient();
		Notes resp = client.target("http://localhost:8080/back-end/api/notes").request("application/json").post(Entity.entity(note, MediaType.APPLICATION_JSON)
                , Notes.class);
		
		if (resp != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		}	
	}
}