package bussines;

import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.IUserDAO;
import dto.User;

@Stateless
public class UserBussines implements IUserBussines {
	
	@EJB
	IUserDAO userDAO;
	
	@Override
	public List<User> getUsers() {
		return this.userDAO.getUsers();
	}

	@Override
	public void addUser(User user) throws Exception {
		this.userDAO.addUser(user);
		
	}

	@Override
	public User getUserByCredentials(String email, String pass) {
		return userDAO.getUserByCredentials(email, pass);
	}

	@Override
	public User getUserById(UUID idUser) {
		return userDAO.getUserById(idUser);
	}
	
	

}
