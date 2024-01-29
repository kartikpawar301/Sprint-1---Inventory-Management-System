package com.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ims.entity.Customer;
import com.ims.model.CustomerDTO;
import com.ims.service.CustomerService;
import com.ims.util.CustomerConverter;

@RestController
@RequestMapping("/ims/Customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController 
{
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerConverter customerConverter;
	
	// http://localhost:8080/ims/Customer/addCustomer
	@PostMapping("addCustomer")
	public CustomerDTO saveCustomer(@RequestBody CustomerDTO cDto) 
	{	
		Customer customer = customerConverter.convertToEntity(cDto);
		return customerService.addCustomer(customer);
	}
	
	@GetMapping("getCustomerById/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") int customerId)
	{
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}
	
	@PutMapping("editCustomer/{customerId}")
	public ResponseEntity<Customer>editCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer)
	{
		return new ResponseEntity<Customer>(customerService.updateCustomerDetails(customer, customerId), HttpStatus.OK);
	}
	
	@DeleteMapping("deleteCustomer/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") int customerId)
	{
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<String>("Customer Deleted Successfully...", HttpStatus.OK);
	}
	
	@GetMapping("getAllCustomer")
	public List<CustomerDTO> getCustomers() {
		
		return customerService.getAllCustomers();
	}
	
	@GetMapping("getCustomerName/{customerName}")
	public List<Customer> getCustomerByName(@PathVariable("customerName") String customerName) {
		
		return customerService.getCustomerByName(customerName);
	}
	
}
