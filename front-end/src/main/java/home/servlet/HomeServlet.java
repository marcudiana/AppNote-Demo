package home.servlet;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import dto.Notes;
import dto.Tags;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UUID idUser = (UUID) session.getAttribute("idUser");

		List<Notes> notes = null;
		try {
			Client client = ClientBuilder.newClient();
			notes = client.target("http://localhost:8080/back-end/api/notes/user/" + idUser.toString())
					.request("application/json").get(new GenericType<List<Notes>>() {});
		} catch (NotFoundException e) {
			System.out.println("Notes not found");
		}

		List<Tags> tags = null;
		try {
			Client client = ClientBuilder.newClient();
			tags = client.target("http://localhost:8080/back-end/api/tag").request("application/json")
					.get(new GenericType<List<Tags>>() {});
		} catch (NotFoundException e) {
			System.out.println("Tag not found");
		}

		if (notes != null && tags != null) {
			req.setAttribute("notes", notes);
			req.setAttribute("tags", tags);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
