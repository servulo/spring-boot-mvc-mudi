package br.com.sprj.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sprj.mvc.mudi.dto.NewOrderDto;
import br.com.sprj.mvc.mudi.model.Order;
import br.com.sprj.mvc.mudi.repository.OrderRepository;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("form")
    public String form(NewOrderDto newOrderDto) {
	return "order/form";
    }

    @PostMapping("new")
    public String newOrder(@Valid NewOrderDto newOrderDto, BindingResult result) {
	if (result.hasErrors()) {
	    return "order/form";
	}
	Order order = newOrderDto.toOrder();
	orderRepository.save(order);
	return "order/form";
    }

}