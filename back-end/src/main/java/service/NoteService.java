package service;

import java.util.List;
import java.util.UUID;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import bussines.INoteBussines;
import dto.Note;

@Stateless
@Path("/notes")
public class NoteService {
	
	@EJB
	INoteBussines noteBussines; 

	@POST
	@Path("/")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
	public Response addNotes(final @Context HttpServletRequest request, Note note) throws Exception {
		noteBussines.addNotes(note);
		return Response.status(Status.CREATED).entity(note).build();
	}
	
	
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	public Response getNotes(final @Context HttpServletRequest req) {
		List<Note> notes = noteBussines.getNotes();
		return Response.status(Status.OK).entity(notes).build();
	
	}
	
	@GET
	@Path("/{idNote}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	public Response getNotesById(final @Context HttpServletRequest request, @PathParam("idNote") UUID idNote) {
		Note note = noteBussines.getNotesById(idNote);
		
		if(note != null) {
			return Response.status(Status.OK).entity(note).build();
		}
		else {
			return Response.status(Status.NOT_FOUND).entity("Note not found!").build();
		}
	}
	
	
	@DELETE
	@Path("/{idNote}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	public Response removeNote(final @Context HttpServletRequest request, @PathParam("idNote") UUID idNote) {
		noteBussines.removeNoteById(idNote);
		return Response.status(Status.OK).entity(idNote).build();
	}
	
	@GET
	@Path("/user/{idUser}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	public Response getNotesByUser(final @Context HttpServletRequest request, @PathParam("idUser") UUID idUser) {
		List<Note> notes = noteBussines.getNotesByUser(idUser);
		
		if(notes != null) {
			return Response.status(Status.OK).entity(notes).build();
		}
		else {
			return Response.status(Status.NOT_FOUND).entity("Note not found!").build();
		}
	}
}

