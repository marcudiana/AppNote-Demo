package service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import bussines.ITagBussines;
import dto.Tag;

@Stateless
@Path("/tag")
public class TagService {
	@EJB
	ITagBussines tagBussines;
	
	@POST
	@Path("/")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
	public Response addTag(final @Context HttpServletRequest request, Tag tag) throws Exception {
		tagBussines.addTag(tag);

		return Response.status(Status.CREATED).entity(tag).build();
	}
	
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
	public Response getTag(final @Context HttpServletRequest req) {
		List<Tag> tag = tagBussines.getTags();
		return Response.status(Status.OK).entity(tag).build();
	}
		
		
}