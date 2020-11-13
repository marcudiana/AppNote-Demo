package dao;

import java.util.List;
import java.util.UUID;

import dto.User;

public interface IUserDAO {
	
	public List<User> getUsers();
	public void addUser(final User user);
	public User getUserByCredentials(String email, String pass);
	public User getUserById(UUID idUser);

}
