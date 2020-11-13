package service;

import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import bussines.IUserBussines;
import dto.User;

@Stateless
@Path("/user")
public class UserService {

	@EJB
	IUserBussines userBussines;

	@GET
	@Path("/")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
	public Response getUsers(final @Context HttpServletRequest req) {
		List<User> users = userBussines.getUsers();
		return Response.status(Status.OK).entity(users).build();

	}

	@POST
	@Path("/")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
	public Response addUser(final @Context HttpServletRequest request, User user) throws Exception {
		userBussines.addUser(user);

		return Response.status(Status.CREATED).entity(user).build();
	}

	@GET
	@Path("/{email}/{pass}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response getUserByCredentials(final @Context HttpServletRequest request, @PathParam("email") String email,
																					@PathParam("pass") String pass) {
		User user = userBussines.getUserByCredentials(email, pass);

		if (user != null) {
			return Response.status(Status.OK).entity(user).build();
		} else {
			return Response.status(Status.NOT_FOUND).entity("USER NOT FOUND!").build();
		}
	}
	
	@GET
	@Path("/{idUser}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
	public Response getUserById(final @Context HttpServletRequest req, @PathParam("idUser") UUID idUser) {
		User user = userBussines.getUserById(idUser);
		
		if(user != null) {
			return Response.status(Status.OK).entity(user).build();
		}
		else {
			return Response.status(Status.NOT_FOUND).entity("Id inexistent!").build();
		}
	}

}
