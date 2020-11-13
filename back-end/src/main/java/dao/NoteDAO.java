package dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import dto.Note;
import dto.Tag;
import dto.User;

@Stateless
public class NoteDAO implements INoteDAO {
	
	@EJB
	IUserDAO userDAO;
	
	@EJB
	ITagDAO tagDAO;

	@PersistenceContext(unitName = "planner", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	public void addNotes(Note note) {
		Session session = this.entityManager.unwrap(Session.class);
		UUID idUser = note.getIdUser();
		User user = userDAO.getUserById(idUser);
		note.setUser(user);
		
//		note.getRequestTags();
//		Set<UUID> set = new HashSet<UUID>();
//		for(UUID idTags : set) {
//			set.add(tagDAO.getTagById(idTags));	
//		}
//		note.setIdTag(set);
		session.save(note);
	}
	
	@Override
	public List<Note> getNotes() {
		Session session = this.entityManager.unwrap(Session.class);
		return (List<Note>) session.createQuery("from Notes").list();
	}

	@Override
	public Note getNotesById(UUID idNote) {
		Session session = this.entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Note.class).add(Restrictions.eq("idNote", idNote));
		return (Note) criteria.uniqueResult();
	}
	
	@Override
	public void removeNoteById(UUID idNote) {
		Session session = this.entityManager.unwrap(Session.class);
		Note note = (Note) session.createCriteria(Note.class).add(Restrictions.eq("idNote", idNote)).uniqueResult();
		session.delete(note);
	}
	
	@Override
	public List<Note> getNotesByUser(UUID idUser) {
		Session session = this.entityManager.unwrap(Session.class);
		User user = userDAO.getUserById(idUser);
		Criteria criteria = session.createCriteria(Note.class).add(Restrictions.eq("user", user));
		return (List<Note>) criteria.list();
	}
}
