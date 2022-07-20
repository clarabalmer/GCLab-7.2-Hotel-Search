package co.grandcircus.HotelSearch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HotelController {
	@Autowired
	private HotelRepository repo;
	
	@RequestMapping("/")
	public String showIndex() {
		return "redirect:/home";
	}
	@RequestMapping("/home")
	public String showHome(Model model) {
		List<Hotel> hotels = repo.findAll();
		ArrayList<String> cities = new ArrayList<>();
		for (Hotel h : hotels) {
			if (!cities.contains(h.getCity())) {
				cities.add(h.getCity());
			}
		}
		model.addAttribute("cities", cities);
		return "home";
	}
	@PostMapping("/citySelect")
	public String showResults(@RequestParam String city, Model model) {
		List<Hotel> cityHotels = repo.findByCityOrderByPricePerNightAsc(city);
		
		model.addAttribute("city", city);
		model.addAttribute("cityHotels", cityHotels);
		return "results";
	}
}
