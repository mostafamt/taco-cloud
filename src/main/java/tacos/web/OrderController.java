package tacos.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tacos.Order;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
	
	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("order", new Order());
		return "orderForm";
	}
	
	@PostMapping
	public String processData(@Valid Order order, Errors errors) {
		System.out.println("------------------ Hello ------------------");
		System.out.println(order);
		System.out.println("errors: " + errors);
		if(errors.hasErrors()) {
			return "orderForm";
		}
//		System.out.println("Order submitted: " + order);
		log.info("Order submitted: " + order);
		return "redirect:/";
	}

}
