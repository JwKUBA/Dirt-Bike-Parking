package pl.dirtbikeparking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.dirtbikeparking.entity.Notice;
import pl.dirtbikeparking.repository.NoticeRepository;

@Controller
@RequestMapping("brands")
public class BrandListController {
	
	
	@Autowired
	NoticeRepository noticeRepository;
	
	
	
	@GetMapping("/{brand}")
	public String getBrands(@PathVariable String brand, Model m) {
		List<Notice> notice = noticeRepository.findBrand(brand);
		m.addAttribute("brands",notice);
		return "brand/brands";
		
	}

}
