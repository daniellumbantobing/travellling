package del.ac.id.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import del.ac.id.demo.jpa.User;
import del.ac.id.demo.jpa.UserRepository;

@RestController
public class UserController {

	
	public UserController(UserRepository userRepository) {
	}
	

	
	@GetMapping("/user")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("user");
		mv.addObject("user", new User());
		return mv;
	}
	
}
