package pl.dirtbikeparking.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pl.dirtbikeparking.bean.LoginData;
import pl.dirtbikeparking.bean.SessionManager;
import pl.dirtbikeparking.entity.User;
import pl.dirtbikeparking.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/register")
	public String register(Model m) {
		m.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerPost(@Valid @ModelAttribute User user, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "redirect:/register";
		}
		this.userRepository.save(user);
		if(user.getId() == 1) {
			user.setAdmin(true);
			this.userRepository.save(user);
		}
		return "redirect:/";
		
	}
	
	@GetMapping("/login")
	public String login(Model m) {
		m.addAttribute("loginData", new LoginData());
		return "login";
		
	}
	
	
	@PostMapping("/login")
	public String loginPost(@ModelAttribute LoginData loginData, Model m) {
		User user = this.userRepository.findOneByEmail(loginData.getEmail());
		if(user!=null&& user.checkPassword(loginData.getPassword())) {
			HttpSession s = SessionManager.session();
			s.setAttribute("user", user);
			return "redirect:/";
		}
		
		m.addAttribute("msg", "Wprowadz poprawne dane");
		return "login";
	}
	
	
	@GetMapping("/logout")
	public String loginPost(Model m) {
		HttpSession s = SessionManager.session();
		s.invalidate();
		m.addAttribute("loginData", new LoginData());
		return "redirect:/";
		
	}
	
	
	@GetMapping("/change")
	public String change(Model m) {
		HttpSession s = SessionManager.session();
		User u =(User) s.getAttribute("user");
		m.addAttribute("user",u);
		return "change";
	}
	
	@GetMapping("/user/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		User user = this.userRepository.findById(id);
		m.addAttribute("user", user);
		return "edit";
		
	}
		
	@PostMapping("/user/edit/{id}")
	public String postEdit(@Valid @ModelAttribute User user, BindingResult bindingResult,Model m) {
		if(bindingResult.hasErrors()) {
			return "redirect:/edit";
		}
		this.userRepository.save(user);
		m.addAttribute("msg", "edytowano");
		return "redirect:/";
		
	}  
	
	@GetMapping("/user/delete")	
	public String delete(Model m) {
		HttpSession s = SessionManager.session();
				User user= (User) s.getAttribute("user");
		m.addAttribute("user" , user);
		return "delete_user";
	}
	
	@GetMapping("/user/delete/{dec}")
	public String deletePost(@PathVariable int dec, @ModelAttribute User user) {
		if(dec==1) {
			HttpSession s = SessionManager.session();
			User u =(User) s.getAttribute("user");
			s.invalidate();
			this.userRepository.delete(user);
			return "redirect:/";
		}
		return "redirect:/";
	}
			
			
			
			
			
			
			
			
			
			
			
			
			
	
			
}
