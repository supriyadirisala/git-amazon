package com.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Login {

@Autowired
private OtpGenerator otpGeneratorObj;
/*

@Autowired
CustomerPojo customerPojoObj;
*/

	@RequestMapping(value={"", "/page", "page*","view/*","/login"}, method = RequestMethod.GET)
	public ModelAndView logIn(HttpServletRequest req, Model model) {
		ModelAndView mavLoginPage = new ModelAndView("login"); //login.js
		return mavLoginPage;
	}
	char[] otpArray = null;
	String otp = null;

	
	@RequestMapping(value={"/otpPage","/otp"},method = RequestMethod.GET)
	public ModelAndView otpPage(HttpServletRequest req, Model model){		
		otpArray = OtpGenerator.generateOTP(4);
		otp = String.valueOf(otpArray);
		String custNameFromUser =  req.getParameter("custName");
		String custmobileNo =  req.getParameter("mobileNo");
		
		req.getSession().setAttribute("custNameFromUser", custNameFromUser);
		//req.setAttribute("custNameFromUser",custNameFromUser);
		
		//customerPojoObj.setCustName(req.getParameter("custName"));
		//customerPojoObj.setMobileNum(Long.parseLong(custmobileNo));
		//System.out.println(customerPojoObj);		
		System.out.println("custNameFromUser : "+custNameFromUser);
		System.out.println("custmobileNo : "+custmobileNo);
		///model.addAttribute("custNameKey",custNameFromUser);
		ModelAndView otpGenerate = new ModelAndView("otpPage");//otpPage.jsp
	return otpGenerate;
}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homeLogIn(HttpServletRequest req, Model model){		
		String otpFromUser =  req.getParameter("otpFromUserUI");
		//model.addAttribute("otpFromUser",otpFromUser);
		//String mobileNoFromUser =  req.getParameter("mobileNo");
		System.out.println("otpFromUser : "+otpFromUser);
		System.out.println("otp : "+otp);
		String custNameFromUser = (String)req.getSession().getAttribute("custNameFromUser");
		System.out.println("custNameFromUser from another servlet : "+custNameFromUser);
		ModelAndView mavhomelogin =  null;
		if(otpFromUser.equals(otp)) { //otpFromUser == otp
			mavhomelogin = new ModelAndView("home");//home.jsp
		}
		else {
			mavhomelogin = new ModelAndView("loginFailed");//loginFailed.jsp
		}
	return mavhomelogin;
	}
}