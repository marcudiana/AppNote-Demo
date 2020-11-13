package bussines;

import java.util.List;
import java.util.UUID;

import dto.Note;

public interface INoteBussines {

	public List<Note> getNotes();
	public void addNotes(final Note note) throws Exception;
	public Note getNotesById(UUID idNote);
	public void removeNoteById(UUID idNote);
	public List<Note> getNotesByUser(UUID idUser);
}
