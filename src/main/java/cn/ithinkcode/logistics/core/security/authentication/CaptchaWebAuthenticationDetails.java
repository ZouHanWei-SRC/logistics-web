/**
 * 2020 Copyright by ithinkcode.cn All rights reserved
 */
package cn.ithinkcode.logistics.core.security.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.util.StringUtils;

/**
 * @author Harvey
 *
 */
public class CaptchaWebAuthenticationDetails extends WebAuthenticationDetails {

	private boolean captchaCodeIsRight = false;

	public CaptchaWebAuthenticationDetails(HttpServletRequest request) {
		super(request);

		String captchaCode = request.getParameter("captcha");
		HttpSession session = request.getSession();
		String savedcaptchaCode = (String) session.getAttribute("captcha");
		if (!StringUtils.isEmpty(savedcaptchaCode)) {
			session.removeAttribute("captcha");
			if (!StringUtils.isEmpty(captchaCode) && captchaCode.equals(savedcaptchaCode)) {
				this.captchaCodeIsRight = true;
			}
		}
	}

	public boolean isCaptchaCodeIsRight() {
		return captchaCodeIsRight;
	}

	public void setCaptchaCodeIsRight(boolean captchaCodeIsRight) {
		this.captchaCodeIsRight = captchaCodeIsRight;
	}

}
