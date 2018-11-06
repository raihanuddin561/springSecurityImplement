package com.spring.practice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.practice.config.AppConfig;
import com.spring.practice.dao.AppDaoImpl;
import com.spring.practice.model.User;


@Controller
public class AppController {
	@RequestMapping(value= {"/","/home"})
	public ModelAndView homePage() {
		ModelAndView model = new ModelAndView("index");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDaoImpl appDao = context.getBean("daoBean",AppDaoImpl.class);
		List<User> users = new ArrayList<User>();
		users = appDao.userList();
		model.addObject("user",users);
		context.close();
		return model;
	}
	@RequestMapping("/addUser")
	public String addUser(Model model,@Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Has errors");
			model.addAttribute("user",user);
			return "addUser";
		}else {
			if(user.getUsername()!=null && user.getEmail()!=null && user.getPassword()!=null) {
				
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
				AppDaoImpl appDao = context.getBean("daoBean",AppDaoImpl.class);
				appDao.addUser(user);
				context.close();
				return "forward:/";
			}else {
				System.out.println("form loading");
				return "addUser";
			}
		}
		
		
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login");
		return model;
	}
	@RequestMapping("/403")
	public ModelAndView page403() {
		ModelAndView model = new ModelAndView("403");
		return model;
	}
}
