/**
 * 2020 Copyright by ithinkcode.cn All rights reserved
 */
package cn.ithinkcode.logistics.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Harvey
 *
 */
@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "index";
	}
}
