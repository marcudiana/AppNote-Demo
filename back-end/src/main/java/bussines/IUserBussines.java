package bussines;

import java.util.List;
import java.util.UUID;

import dto.User;

public interface IUserBussines {
	public List<User> getUsers();
	public void addUser(final User user) throws Exception;
	public User getUserByCredentials(String email, String pass);
	public User getUserById(UUID idUser);



}
