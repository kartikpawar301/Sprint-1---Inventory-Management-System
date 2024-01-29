package com.ims.service;

import java.util.List;

import com.ims.entity.Customer;
import com.ims.model.CustomerDTO;

public interface CustomerService 
{
	CustomerDTO addCustomer(Customer customer);

	Customer getCustomerById(int customerId);

	Customer updateCustomerDetails(Customer customer, int customerId);

	void deleteCustomer(int customerId);
	
	List<CustomerDTO> getAllCustomers();
	
	List<Customer> getCustomerByName(String customerName);
}
