package vn.iostar.DAO;

import vn.iostar.model.User;

public interface UserService {
	User login(String username, String password);
	User get(String username);
	void insert(User user);
	boolean register(String email, String username, String fullname, String password,String phone);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
}

