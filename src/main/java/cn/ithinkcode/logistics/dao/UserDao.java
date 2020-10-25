/**
 * 2020 Copyright by ithinkcode.cn All rights reserved
 */
package cn.ithinkcode.logistics.dao;

import cn.ithinkcode.logistics.entity.User;

/**
 * @author Harvey
 *
 */
public interface UserDao {

	User findUserByUsername(String username);

	//int insert(User user);
}
