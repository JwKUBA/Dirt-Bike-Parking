package pl.dirtbikeparking.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pl.dirtbikeparking.bean.SessionManager;
import pl.dirtbikeparking.entity.Notice;
import pl.dirtbikeparking.entity.User;
import pl.dirtbikeparking.repository.NoticeRepository;

@Controller
public class NoticeController {

	@Autowired
	NoticeRepository noticeRepository;

	@GetMapping("/add")
	public String register(Model m) {
		m.addAttribute("notice", new Notice());
		return "notice/add_notice";
	}

	@PostMapping("/add")
	public String addProductPost(Model m, @Valid @ModelAttribute Notice notice, BindingResult bindingResult, 
			@RequestParam("fileUrl") MultipartFile file) {
		if (bindingResult.hasErrors()) {
			return "notice/add_notice";
		}
		
		
		HttpSession s = SessionManager.session();
		User u = (User) s.getAttribute("user");
		notice.setCreated(new Date());
		notice.setCreatedBy(u);
		notice.setUser(u);
		notice.setFileUrl(null);
		this.noticeRepository.save(notice);


//pobranie id
			int imgId = notice.getId();
			// budowanie nazwy
			String fileName = null;
			if(!file.isEmpty()) {
				try {
					if(file.getSize()> 1736920){
						m.addAttribute("errorMessage", "Zbyt duży rozmiar pliku");
						return "notice/add_notice";
					}

					String extension = FilenameUtils.getExtension(file.getOriginalFilename());

				if (extension.equals("jpg") || extension.equals("jpeg")) {

						fileName = "zdjecie_" + imgId + "." + extension;
						byte[] bytes = file.getBytes();
						BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(
								"/home/jakub/dirtbikeparking/DirtBikeParking/src/main/webapp/resources/uploads/notice/"
										+ fileName)));
						buffStream.write(bytes);
						buffStream.close();

						// seter dla url
						notice.setFileUrl(fileName);
						// zapis db
						noticeRepository.save(notice);

						//m.addAttribute("message", "Dodano produkt do bazy.");
						return "redirect:/";

					} else {
						//m.addAttribute("errorMessage", "Niepoprawny format pliku graficznego.");
						return "notice/add_notice";
					}

				} catch (Exception e) {
					return "redirect:/";
				}
			}
			m.addAttribute("errorMessage", "Brak zdjęcia.");
			return "notice/add_notice";

		}

	@ModelAttribute("brands")
	public List<String> getBrand() {
		String type[] = new String[] { "Ktm", "Yamaha", "Suzuki", "Honda", "Kawasaki", "Beta", "Sherco", "Husqvarna",
				"Tm", "GasGas", "Husaberg" };
		Arrays.sort(type);
		return Arrays.asList(type);
	}

	@ModelAttribute("engine")
	public List<String> getEngine() {
		String type[] = new String[] { "dwusuw/2t", "czterosuw/4t" };
		Arrays.sort(type);
		return Arrays.asList(type);
	}
}
