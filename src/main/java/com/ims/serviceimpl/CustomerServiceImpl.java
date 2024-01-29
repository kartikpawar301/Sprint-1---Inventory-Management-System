package com.ims.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.entity.Customer;
import com.ims.exception.IdNotFoundException;
import com.ims.model.CustomerDTO;
import com.ims.repository.CustomerRepository;
import com.ims.service.CustomerService;
import com.ims.util.CustomerConverter;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerConverter customerConverter;
	
	@Override
	public CustomerDTO addCustomer(Customer customer) {

		customerRepository.save(customer);
		return customerConverter.convertToCustomerDTO(customer);
	}

	@Override
	public Customer getCustomerById(int customerId) {
	
		return customerRepository.findById(customerId).orElseThrow( ()-> new IdNotFoundException("Customer id is not found"));
	}

	@Override
	public Customer updateCustomerDetails(Customer customer, int customerId) {
		
		Customer updateCustomer = customerRepository.findById(customerId).orElseThrow( ()-> new IdNotFoundException("Customer id is not correct"));
		updateCustomer.setCustomerName(customer.getCustomerName());
		updateCustomer.setCustomerAddress(customer.getCustomerAddress());
		updateCustomer.setCustomerMobileNumber(customer.getCustomerMobileNumber());
		
		customerRepository.save(updateCustomer);
		
		return updateCustomer;
	}

	@Override
	public void deleteCustomer(int customerId) {
		
		customerRepository.findById(customerId).orElseThrow( ()-> new IdNotFoundException("Customer id is not correct"));
		customerRepository.deleteById(customerId);
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		
		List<Customer> customer = customerRepository.findAll();
		
		List<CustomerDTO> dtoList = new ArrayList<>();
		for(Customer c: customer)
		{
			dtoList.add(customerConverter.convertToCustomerDTO(c));
		}
		return dtoList;
	}

	@Override
	public List<Customer> getCustomerByName(String customerName) {
		
		return customerRepository.findCustomerByName(customerName);
	}
	
}
