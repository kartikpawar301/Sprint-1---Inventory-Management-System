package com.ims.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ims.entity.Customer;
import com.ims.model.CustomerDTO;

@Component
public class CustomerConverter 
{
	// Converting Customer Entity to Customer DTO
	public CustomerDTO convertToCustomerDTO(Customer customer)
	{
		CustomerDTO cDto = new CustomerDTO();
		if(customer!=null)
			{
				BeanUtils.copyProperties(customer, cDto);
			}
		return cDto;
	}
			
	// Converting Customer DTO to Customer Entity
	public Customer convertToEntity(CustomerDTO cDto)
	{
		Customer customer = new Customer();
		if(cDto!=null)
		{
			BeanUtils.copyProperties(cDto, customer);
		}
		return customer;
	}

}
