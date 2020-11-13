package dao;

import java.util.List;
import java.util.UUID;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import dto.Tag;

@Stateless
public class TagDAO implements ITagDAO {
	
	@EJB
	INoteDAO noteDAO;
	
	@PersistenceContext(unitName = "planner", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	@Override
	public void addTags(Tag tag) {
		Session session = this.entityManager.unwrap(Session.class);
		session.save(tag);
	}

	@Override
	public List<Tag> getTags() {
		Session session = this.entityManager.unwrap(Session.class);
		return(List<Tag>) session.createQuery("from Tags").list();
	}

	@Override
	public Tag getTagById(UUID idTag) {
		Session session = this.entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Tag.class).add(Restrictions.eq("idTag", idTag));
		return (Tag) criteria.uniqueResult();
	}
}