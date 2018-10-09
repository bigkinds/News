package cn.smbms.dao;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.User;

public interface UserMapper {
	public User login(@Param(value = "userCode") String userCode);

}
