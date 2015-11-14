package com.jvtestbd.javarush.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.jvtestbd.javarush.domain.User;
import com.jvtestbd.javarush.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/main")
public class MainController {
	int offset = 0;
	int num = 3;
	public static int count = 0;
	public static Model model1;

	
	@Resource(name="userService")
	private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getUsers(Model model) {
		List<User> usersfull = userService.getAll();
		List<User> users = userService.getAllPage(0, 3);
		if (usersfull.size() < 3) {
			count = 1;
		}else if (usersfull.size() > 3 && usersfull.size() % 3 > 0){
			count = usersfull.size()/3+1;
		}else{
			count = usersfull.size()/3;
		}

		model.addAttribute("count", count);
		model.addAttribute("users", users);
		model.addAttribute("usersfull", usersfull);
		return "userspage";
	}

	@RequestMapping(value = "/usersPage", method = RequestMethod.GET)
	public String getUsers(@RequestParam(value="numpage", required=true) Integer numpage, Model model) {
		List<User> usersfull = userService.getAll();
		offset = numpage*3-3;
		List<User> users = userService.getAllPage(offset, num);
		if (usersfull.size() < 3) {
			count = 1;
		}else if (usersfull.size() > 3 && usersfull.size() % 3 > 0){
			count = usersfull.size()/3+1;
		}else{
			count = usersfull.size()/3;
		}
		model.addAttribute("count", count);
		model.addAttribute("users", users);
		model.addAttribute("usersfull", usersfull);
		return "userspage";
	}

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
    	model.addAttribute("userAttribute", new User());
    	return "addpage";
	}

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("userAttribute") User user) {
		user.setDate(new Date());
		userService.add(user);
		return "addedpage";
	}

    @RequestMapping(value = "/users/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) Integer id, Model model) {
		userService.delete(id);
		model.addAttribute("id", id);
		return "deletedpage";
	}

    @RequestMapping(value = "/users/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value="id", required=true) Integer id, Model model) {
    	model.addAttribute("userAttribute", userService.get(id));
    	return "editpage";
	}

    @RequestMapping(value = "/users/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("userAttribute") User user, @RequestParam(value="id", required=true) Integer id, Model model) {
    	user.setId(id);
		userService.edit(user);
		model.addAttribute("id", id);
		return "editedpage";
	}

	@RequestMapping(value = "/users/filter", method = RequestMethod.GET)
	public String getFilter(Model model) {
		model.addAttribute("userFilter", new User());
		return "filter";
	}
	@RequestMapping(value = "/users/filter", method = RequestMethod.POST)
	public String listFilter(@ModelAttribute("userAttribute") User user, Model model) {
		List<User> users = userService.getNotAll(user.getName());
		model.addAttribute("users", users);
		return "filterpage";
	}
    
}
