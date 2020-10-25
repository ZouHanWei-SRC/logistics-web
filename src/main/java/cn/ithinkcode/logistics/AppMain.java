/**
 * 2020 Copyright by ithinkcode.cn All rights reserved
 */
package cn.ithinkcode.logistics;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Harvey
 *
 */
public class AppMain {
	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode("123"));
	}
}
