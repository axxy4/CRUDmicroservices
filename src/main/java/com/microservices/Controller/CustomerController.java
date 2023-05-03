package com.microservices.Controller;

import java.util.List;

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

import com.microservices.Payload.CustomerDto;
import com.microservices.Service.CustomerService;

import lombok.Delegate;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<CustomerDto> createNewCustomer(@RequestBody CustomerDto customerDto){
		CustomerDto newCustomer = customerService.createNewCustomer(customerDto);
		return new ResponseEntity<>(newCustomer,HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<CustomerDto> getAllData(){
		return customerService.getAllCustomer();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") long id){
		customerService.deleteById(id);
		return ResponseEntity.ok("Customer Deleted Successfully");
	}
	
	
	@PutMapping("/{id}") 
	public ResponseEntity<CustomerDto> updateById(@RequestBody CustomerDto customerDto, @PathVariable("id") long id){
		CustomerDto updateById = customerService.updateById(customerDto, id);
		return new ResponseEntity<CustomerDto>(updateById, HttpStatus.OK);
	}
}
