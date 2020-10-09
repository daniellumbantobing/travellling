package del.ac.id.demo.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import del.ac.id.demo.jpa.User;
import del.ac.id.demo.jpa.UserRepository;

@RestController
public class LoginController {
	private UserRepository userRepository;
	
	public LoginController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("user", new User());
		return mv;
	}
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("user", new User());
		return mv;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView loginSubmit(@ModelAttribute User user, BindingResult bindingResult, Model model) {
		
		  model.addAttribute("user", user);
	        User userRole = userRepository.findByUsername(user.getUsername());

	        System.out.println(userRole.getRoleid());

	        if(userRole.getRoleid() == 1){
	            return new ModelAndView("redirect:/admin");
	        }
	        if(userRole.getRoleid() == 2){
	            return new ModelAndView("redirect:/user");
	        }else{
	            return new ModelAndView("redirect:/login");
	        }
	    }
}
