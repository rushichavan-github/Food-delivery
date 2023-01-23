package com.example.onlinefooddelivery.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinefooddelivery.entities.Order;
import com.example.onlinefooddelivery.exceptions.NoOrderFoundException;
import com.example.onlinefooddelivery.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
		
		@Autowired
		private OrderService ordServ;
		
		@PostMapping("/add")
		public ResponseEntity<Order> addOrder(@RequestBody Order order){
			Order savedOrder = ordServ.addOrder(order);
			return new ResponseEntity<Order>(savedOrder,HttpStatus.OK);
		}
		
		@PutMapping("/update")
		public ResponseEntity<Order> updateOrder(@RequestBody Order order) throws NoOrderFoundException{
			Order updateOrder = ordServ.updateOrder(order);
			return new ResponseEntity<Order>(updateOrder,HttpStatus.ACCEPTED);
		}
		
		@GetMapping("/view/{id}")
		public ResponseEntity<Optional<Order> > viewOrderById(@PathVariable long id) throws NoOrderFoundException{
			Optional<Order>  order = ordServ.viewOrderById(id);
			return new ResponseEntity<> (order,HttpStatus.OK);
		}
		
		@GetMapping("/viewAll")
		public ResponseEntity<List<Order>> viewAllOrder() throws NoOrderFoundException{
			List<Order> allOrder = ordServ.viewAllOrder();
 		return new ResponseEntity<List<Order>>(allOrder,HttpStatus.FOUND);
		}
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> deleteOrder(@PathVariable long id) throws NoOrderFoundException{
			String  m = ordServ.deleteOrder(id);
			return new ResponseEntity<String>(m,HttpStatus.ACCEPTED);
		}
		
}
