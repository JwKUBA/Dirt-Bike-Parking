package pl.dirtbikeparking.controller;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pl.dirtbikeparking.bean.SessionManager;
import pl.dirtbikeparking.entity.Notice;
import pl.dirtbikeparking.entity.ToObserve;
import pl.dirtbikeparking.entity.User;
import pl.dirtbikeparking.repository.NoticeRepository;
import pl.dirtbikeparking.repository.ToObserveRepository;
import pl.dirtbikeparking.repository.UserRepository;

@Controller
public class ToObserveController {
	
	@Autowired
	NoticeRepository noticeRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ToObserveRepository toObserveRepository;
	
	
	
	
	@GetMapping("/toObserve/{id}")
	public String toObserve(Model m, @PathVariable int id ,@ModelAttribute ToObserve toObserve) {
		Notice notice = this.noticeRepository.findById(id);// znalezione ogłosznie
		HttpSession s = SessionManager.session();
		User user = (User) s.getAttribute("user");// znaleziony user z sesji
		toObserve.setTest(1);
		toObserve.setToObserve(user);
		toObserve.setNotice(notice);
		toObserveRepository.save(toObserve);
		return "redirect:/toObserve";

	}
	
	@GetMapping("/toObserve")
	public String Observe(Model m) {
		HttpSession s = SessionManager.session();
		User user = (User) s.getAttribute("user");
		List<ToObserve> toObserve = this.toObserveRepository.findAllBytoObserve(user);
		m.addAttribute("toObserve", toObserve);
		 return "/notice/toObserve";
	}
	
	@GetMapping("/toObserve/delete/{id}")
	public String observeDelete(Model m, @PathVariable int id) {
		Notice notice = this.noticeRepository.findById(id);
		ToObserve toObserve = this.toObserveRepository.findByNotice(notice); 
		toObserveRepository.delete(toObserve);
		return "redirect:/toObserve";
	}

}
