package com.ims.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ims.entity.Sales;
import com.ims.model.SalesDTO;

@Component
public class SalesConverter 
{
	// Converting Sales Entity to Sales DTO
	public SalesDTO convertToSalesDTO(Sales sales)
	{
		SalesDTO s1Dto = new SalesDTO();
		if(sales!=null)
			{
				BeanUtils.copyProperties(sales, s1Dto);
			}
		return s1Dto;
	}
			
	// Converting Sales DTO to Sales Entity
	public Sales convertToEntity(SalesDTO s1Dto)
	{
		Sales sales = new Sales();
		if(s1Dto!=null)
		{
			BeanUtils.copyProperties(s1Dto, sales);
		}
		return sales;
	}

}
