package del.ac.id.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import del.ac.id.demo.jpa.Penerbangan;
import del.ac.id.demo.jpa.PenerbanganRepository;
import del.ac.id.demo.jpa.Role;
import del.ac.id.demo.jpa.User;
import del.ac.id.service.PenerbanganServie;

@RestController
@Controller
public class AdminController {
	private PenerbanganRepository penerbanganRepository;
	
	@Autowired
	private PenerbanganServie penerbanganService;
	
	public AdminController(PenerbanganRepository penerbanganRepository) {
		this.penerbanganRepository = penerbanganRepository;
	}
	

	
	@GetMapping("/admin")
	public ModelAndView admin() {
		List<Penerbangan> listPenerbangan = penerbanganRepository.findAll();
		System.out.println(listPenerbangan.size());
		ModelAndView mv = new ModelAndView("admin"); 
		mv.addObject("penerbangans", listPenerbangan); 
		

		return mv;
}

	
	@GetMapping("/add")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("add");
		mv.addObject("penerbangan", new Penerbangan());
		return mv;
	}
	
	@PostMapping("/savePenerbangan")
	public ModelAndView saveEmployee(@ModelAttribute("penerbangan") Penerbangan penerbangan) {
		penerbanganService.savePenerbangan(penerbangan);
		return new ModelAndView("redirect:/admin");
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView deleteEmployee(@PathVariable(value="id") Long id) {
		this.penerbanganService.deletePenerbanganId(id);
		return new ModelAndView("redirect:/admin");
	}
	
}
