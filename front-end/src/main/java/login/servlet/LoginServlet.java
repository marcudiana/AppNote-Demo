package login.servlet;

import java.io.IOException;
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
import dto.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		User valid = fetchUser(email, pass);

			if (valid != null) {
				HttpSession session = req.getSession();
				session.setAttribute("idUser", valid.getIdUser());
				session.setAttribute("email", email);

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home");
				dispatcher.forward(req, resp);
			} else {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
				dispatcher.forward(req, resp);
			}
		}

	protected User fetchUser(String email, String pass) {
		User user = null;
		try {
			Client client = ClientBuilder.newClient();
			user = client.target("http://localhost:8080/back-end/api/user/" + email + "/" + pass).request("application/json")
					.get(User.class);
		} 
		catch(NotFoundException e) {
			System.out.println("User not found");
		}
		return user;
	}

}
