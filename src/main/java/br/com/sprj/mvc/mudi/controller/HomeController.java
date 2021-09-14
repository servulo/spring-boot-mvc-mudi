package br.com.sprj.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.sprj.mvc.mudi.model.Order;
import br.com.sprj.mvc.mudi.repository.OrderRepository;

@Controller
public class HomeController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/home")
    public String home(Model model) {
	List<Order> orders = orderRepository.findAll();
	model.addAttribute("orders", orders);
	return "home";
    }
    
    /*
    @GetMapping("/home-alt")
    public ModelAndView home() {
	List<Order> orders = orderRepository.findAll();
	ModelAndView modelAndView = new ModelAndView("home");
	modelAndView.addObject("orders", orders);
	return modelAndView;
    }
    */
    
}