package cn.smbms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.smbms.dao.UserMapper;
import cn.smbms.pojo.User;

@Service("userService")
public class UserServiceImple implements UserService {
	@Autowired
	private UserMapper uMapper;

	public User login(String userCode, String userPassword) {
		User user = null;
		user = uMapper.login(userCode);
		// ∆•≈‰√‹¬Î
		if (null != user) {
			user.getUserPassword().equals(userPassword);
		} else {
			user = null;
		}
		return user;
	}

}
