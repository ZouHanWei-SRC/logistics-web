/**
 * 2020 Copyright by ithinkcode.cn All rights reserved
 */
package cn.ithinkcode.logistics.core.security.userdetails;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.ithinkcode.logistics.dao.UserDao;
import cn.ithinkcode.logistics.entity.User;

/**
 * @author Harvey
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			User user = userDao.findUserByUsername(username);
			if (user == null) {
				throw new UsernameNotFoundException("用户名不存在!");
			} else {
				List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
				authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
				return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
						authorities);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
