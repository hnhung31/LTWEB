package vn.iostar.services.Impl;

import vn.iostar.DAO.UserDao;
import vn.iostar.DAO.Impl.UserDaoImpl;
import vn.iostar.services.UserService;
import vn.iostar.model.User;

public class UserServiceImpl implements UserService {
	// lấy tất cả hàm trong tầng DAO
	public UserDao userDao = new UserDaoImpl();

	@Override
	public User login(String username, String password) {
		User user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
		}

	@Override
	public User get(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insert(User user) {
		userDao.insert(user);
		
	}
	@Override
	public boolean register(String email, String username, String fullname, String password, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
		userDao.insert(new User(email, username, fullname,password,null,5,phone,date));
		return true;

	}
	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}
	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}
	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}
	@Override
	public boolean updatePassword(String username, String password) {
		if (!userDao.checkExistUsername(username)) 
		{
	        return false;
	    }
	   	userDao.updatePassword(username, password);
	    return true;
	}
}

