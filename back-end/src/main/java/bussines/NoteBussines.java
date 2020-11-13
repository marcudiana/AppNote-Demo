package bussines;

import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.INoteDAO;
import dto.Note;

@Stateless
public class NoteBussines implements INoteBussines {
	
	@EJB
	INoteDAO noteDAO;
	
	@Override
	public List<Note> getNotes() {
		return this.noteDAO.getNotes();
	}

	@Override
	public void addNotes(Note note) throws Exception {
		this.noteDAO.addNotes(note);
	}

	@Override
	public Note getNotesById(UUID idNote) {
		return noteDAO.getNotesById(idNote);
	}
	
	@Override
	public void removeNoteById(UUID idNote) {
		this.noteDAO.removeNoteById(idNote);
	}

	@Override
	public List<Note> getNotesByUser(UUID idUser) {
		return this.noteDAO.getNotesByUser(idUser);
	}
}
