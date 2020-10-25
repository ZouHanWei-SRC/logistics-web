/**
 * 2020 Copyright by ithinkcode.cn All rights reserved
 */
package cn.ithinkcode.logistics.core.security.authentication;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 * @author Harvey
 *
 */
public class CaptchaWebAuthenticationDetailsSource
		implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {

	@Override
	public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
		return new CaptchaWebAuthenticationDetails(context);
	}

}
