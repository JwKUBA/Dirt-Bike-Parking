package pl.dirtbikeparking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.dirtbikeparking.entity.Notice;
import pl.dirtbikeparking.repository.NoticeRepository;


@Controller
public class HomePageController {
	
	
	@Autowired
	NoticeRepository noticeRepository;
	
	@GetMapping("")
	public String home(Model m) {
		List<Notice> notice = noticeRepository.findAll();
		m.addAttribute("allNotice",notice);
		return "home";
	}


}
