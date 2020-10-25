/**
 * 2020 Copyright by ithinkcode.cn All rights reserved
 */
package cn.ithinkcode.logistics.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 用户注册
 * 
 * @author Harvey
 *
 */
@Controller
public class SignupController {

	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
}
