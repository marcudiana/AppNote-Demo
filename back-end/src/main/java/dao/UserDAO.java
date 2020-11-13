package dao;

import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import dto.User;

@Stateless
public class UserDAO implements IUserDAO {

	@PersistenceContext(unitName = "planner", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	public void addUser(User user) {
		Session session = this.entityManager.unwrap(Session.class);
		session.save(user);
	}

	@Override
	public List<User> getUsers() {
		Session session = this.entityManager.unwrap(Session.class);
		return (List<User>) session.createQuery("from User").list();
	}

	@Override
	public User getUserByCredentials(String email, String pass) {
		Session session = this.entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("email", email))
															  .add(Restrictions.eq("pass", pass));
		return (User) criteria.uniqueResult();

	}
	@Override
	public User getUserById(UUID idUser) {
		Session session = this.entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("idUser", idUser));
		return (User) criteria.uniqueResult();
	}
}
