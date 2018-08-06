package com.ganesh.spring.rest.api.controller;

import com.ganesh.spring.rest.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@GetMapping("/{order}")
	public ResponseEntity<String> showPage(@PathVariable String order) {
		
		return ResponseEntity.ok("Total price of order is: "+orderService.getOrderPrice(order));
	}

}