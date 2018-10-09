package cn.smbms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.smbms.pojo.User;
import cn.smbms.service.UserService;
import cn.smbms.tools.Constants;

@Controller
@RequestMapping("/user")
public class LoginController {
	private Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	private UserService uService;

	@RequestMapping(value = "/login.html")
	public String login() {
		logger.debug("UserController welcome SMBMS==================");
		return "login";
	}

	@RequestMapping(value = "/dologin.html", method = RequestMethod.POST)
	public String doLogin(@Param(value = "userCode") String userCode,
			@Param(value = "userPassword") String userPassword,
			HttpServletRequest request, HttpSession session) {
		User user = null;
		user = uService.login(userCode, userPassword);
		if (null != user) {
			session.setAttribute(Constants.USER_SESSION, user);
			return "redirect:/user/main.html";
		} else {
			request.setAttribute("error", "用户名或者密码错误");
			return "login";
		}
	}

	@RequestMapping(value = "/main.html")
	public String main(HttpSession session) {
		if (session.getAttribute(Constants.USER_SESSION) == null) {
			return "redirect:/user/login.html";
		}
		return "frame";
	}

	@RequestMapping(value = "/logout.html")
	public String logout(HttpSession session) {
		session.removeAttribute(Constants.USER_SESSION);
		return "redirect:/user/login.html";
	}

}
