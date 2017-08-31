package com.marriage.grapefruit.servive;

import com.github.pagehelper.PageInfo;
import com.marriage.grapefruit.model.User;

public interface UserService extends IService<User>{
	
	PageInfo<User> selectByPage(User user, int start, int length);

    User selectByUsername(String username);

    void delUser(Integer userid);
}
