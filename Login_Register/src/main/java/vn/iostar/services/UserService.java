package vn.iostar.services;

import vn.iostar.model.User;

public interface UserService {
	User login(String username, String password);
	User get(String username);
	void insert(User user);
	boolean register(String email, String username, String fullname, String password,String phone);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	boolean updatePassword(String username, String password);
	void updateProfile(String fullname,String phone, String images, String username);

}


