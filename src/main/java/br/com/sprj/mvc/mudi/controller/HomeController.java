package br.com.sprj.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sprj.mvc.mudi.model.Order;
import br.com.sprj.mvc.mudi.model.OrderStatus;
import br.com.sprj.mvc.mudi.repository.OrderRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public String home(Model model) {
	List<Order> orders = orderRepository.findAll();
	model.addAttribute("orders", orders);
	return "home";
    }

    @GetMapping("/{orderStatus}")
    public String getByStatus(@PathVariable("orderStatus") String orderStatus, Model model) {
	List<Order> orders = orderRepository.findByOrderStatus(OrderStatus.valueOf(orderStatus.toUpperCase()));
	model.addAttribute("orders", orders);
	model.addAttribute("status", orderStatus);
	return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
	return "redirect/:home";
    }

}