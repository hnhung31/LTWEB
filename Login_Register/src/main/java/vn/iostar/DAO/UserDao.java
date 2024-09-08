package vn.iostar.DAO;

import vn.iostar.model.User;

public interface UserDao {
	User get(String username);
	User findByUserName(String username);
	void insert(User user);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	
}
