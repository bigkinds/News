package cn.smbms.service;

import cn.smbms.pojo.User;

public interface UserService {
	public User login(String userCode,String userPassword);

}
