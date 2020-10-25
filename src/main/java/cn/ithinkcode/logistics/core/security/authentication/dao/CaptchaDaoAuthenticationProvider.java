/**
 * 2020 Copyright by ithinkcode.cn All rights reserved
 */
package cn.ithinkcode.logistics.core.security.authentication.dao;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import cn.ithinkcode.logistics.core.security.authentication.CaptchaWebAuthenticationDetails;

/**
 * @author Harvey
 *
 */
public class CaptchaDaoAuthenticationProvider extends DaoAuthenticationProvider {

	/**
	 * 验证码是否启用
	 */
	private boolean captchaEnable = false;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// 图形验证码验证逻辑
		Assert.isInstanceOf(UsernamePasswordAuthenticationToken.class, authentication,
				messages.getMessage("AbstractUserDetailsAuthenticationProvider.onlySupports",
						"Only UsernamePasswordAuthenticationToken is supported"));
//		if (captchaEnable && !CaptchaUtils.verify()) {
//			logger.debug("Captcha validation failed ! ");
//			throw new BadCredentialsException(messages.getMessage("captcha.validation.failed", "验证码错误！"));
//		}

		if (captchaEnable) {
			CaptchaWebAuthenticationDetails details = (CaptchaWebAuthenticationDetails) authentication.getDetails();
			if (!details.isCaptchaCodeIsRight()) {
				throw new BadCredentialsException(messages.getMessage("captcha.validation.failed", "验证码错误！"));
			}
		}

		// 调用父类方法完成密码认证
		super.additionalAuthenticationChecks(userDetails, authentication);
	}

	public boolean isCaptchaEnable() {
		return captchaEnable;
	}

	public void setCaptchaEnable(boolean captchaEnable) {
		this.captchaEnable = captchaEnable;
	}

}
