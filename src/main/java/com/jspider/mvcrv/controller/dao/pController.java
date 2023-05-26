package com.jspider.mvcrv.controller.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspider.mvcrv.dto.PetDto;
import com.jspider.mvcrv.service.PetService;
@Controller
public class pController {
	@Autowired
	private PetService service;

	@GetMapping("/login")
	public String login() {
		return "loginPage";
	}

	@PostMapping("/login")
	public String loginData(HttpSession session, HttpServletRequest request, @RequestParam String userName,
			@RequestParam String password, ModelMap map) {
		PetDto pd = service.login(userName, password);
		if (pd!= null) {
			session = request.getSession();
			session.setAttribute("login", pd);
			session.setMaxInactiveInterval(250);
			return "homePage";
		}
		map.addAttribute("msg", "invalid data");
		return "loginPage";
	}

	@GetMapping("/insert")
	public String insertPage(ModelMap map, @SessionAttribute(name = "login", required = false) PetDto pd) {
		if (pd != null) {
			return "insertPet";
		}
		map.addAttribute("msg", "Please login and try again..!!");
		return "loginPage";

	}

	@PostMapping("/insert")
	public String insertData(@RequestParam String pet_name, @RequestParam float pet_weight,
			@RequestParam String pet_color, @RequestParam String userName, @RequestParam String password, ModelMap map,
			@SessionAttribute(name = "login", required = false) PetDto login) {

		if (login != null) {
			PetDto pd = service.insert(pet_name, pet_weight, pet_color, userName, password);
			if (pd != null) {
				map.addAttribute("msg", "pet detail  successfully inserted");
				map.addAttribute("petDetails", pd);
				return "insertPet";
			}
			map.addAttribute("msg", "pet detail not inserted ");
			return "insertPet";
		}
		map.addAttribute("msg", "Please login and try again..!!");
		return "loginPage";
	}

	@GetMapping("/search")
	public String searchPage(ModelMap map, @SessionAttribute(name = "login", required = false) PetDto login) {
		if (login != null) {
			return "searchPet";
		}
		map.addAttribute("msg", "Please login and try again..!!");
		return "loginPage";
	}

	@PostMapping("/search")
	public String searchData(@RequestParam int p_id, ModelMap map,
			@SessionAttribute(name = "login", required = false) PetDto login) {
		if (login != null) {
			PetDto pd = service.search(p_id);
			if (pd != null) {
				map.addAttribute("pet", pd);
			} else {
				map.addAttribute("msg", "pet record not found..!!");
			}

			return "searchPet";
		}
		map.addAttribute("msg", "Please login and try again..!!");
		return "loginPage";
	}

	@GetMapping("/remove")
	public String removePage(ModelMap map, @SessionAttribute(name = "login", required = false) PetDto login) {
		if (login != null) {
			List<PetDto> pd = service.findAllpets();
			map.addAttribute("petList", pd);

			return "removePet";
		}
		map.addAttribute("msg", "Please login and try again..!!");
		return "loginPage";
	}

	@PostMapping("/remove")
	public String removeData(@RequestParam int p_id, ModelMap map,
			@SessionAttribute(name = "login", required = false) PetDto login) {
		if (login != null) {
			service.remove(p_id);
			map.addAttribute("msg", "pet removed successfully..!!");

			List<PetDto> pd = service.findAllpets();
			map.addAttribute("[petList", pd);

			return "removePet";
		}
		map.addAttribute("msg", "Please login and try again..!!");
		return "loginPage";
	}
	@GetMapping("/update")
	public String updatePage(ModelMap map, @SessionAttribute(name = "login", required = false) PetDto login) {
		if (login != null) {
			List<PetDto> pds = service.findAllpets();
			map.addAttribute("employees", pds);
			return "updatePets";

		}
		map.addAttribute("msg", "Please login and try again..!!");
		return "loginPage";
	}
	@PostMapping("/update")
	public String updateData(@RequestParam int id, ModelMap map,
			@SessionAttribute(name = "login", required = false) PetDto login) {
		if (login != null) {
			PetDto pd= service.search(id);
			if (pd != null) {
				map.addAttribute("pet",pd);
			}
			map.addAttribute("msg", "Employee record not found..!!");
			List<PetDto> pds = service.findAllpets();
			map.addAttribute("pet", pds);
			return "updatePets";

		}
		map.addAttribute("msg", "Please login and try again..!!");
		return "loginPage";
}
	@PostMapping("/updateData")
	public String update(@RequestParam int p_id,@RequestParam String pet_name, @RequestParam float pet_weight,
			@RequestParam String pet_color,@RequestParam String userName, @RequestParam String password,
			ModelMap map, @SessionAttribute(name = "login", required = false) PetDto login) {
		if (login != null) {
			service.update(p_id, pet_name, pet_weight, pet_color, userName, password);
			map.addAttribute("msg", "pet updated successfully..!!");

			List<PetDto> pet = service.findAllpets();
			map.addAttribute("pets", pet);
			return "updatePets";

		}
		map.addAttribute("msg", "Please login and try again..!!");
		return "loginPage";
	}
	@GetMapping("/logout")
	public String logout(ModelMap map, HttpSession session) {
		session.invalidate();
		map.addAttribute("msg", "Successfully logged out..!!");
		return "loginPage";
	}
}



