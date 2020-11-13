package dao;

import java.util.List;
import java.util.UUID;

import dto.Note;

public interface INoteDAO {
	
	public List<Note> getNotes();
	public void addNotes(final Note note);
	public Note getNotesById(UUID idNote);
	public void removeNoteById(final UUID idNote);
	public List<Note> getNotesByUser(UUID idUser);
}
