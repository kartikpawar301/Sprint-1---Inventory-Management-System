package com.ims.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ims.entity.Supplier;
import com.ims.model.SupplierDTO;

@Component
public class SupplierConverter 
{
	// Converting Supplier Entity to Supplier DTO
	public SupplierDTO convertToSupplierDTO(Supplier supplier)
	{
		SupplierDTO sDto = new SupplierDTO();
		if(supplier!=null)
			{
				BeanUtils.copyProperties(supplier, sDto);
			}
		return sDto;
	}
			
	// Converting Supplier DTO to Supplier Entity
	public Supplier convertToEntity(SupplierDTO sDto)
	{
		Supplier supplier = new Supplier();
		if(sDto!=null)
		{
			BeanUtils.copyProperties(sDto, supplier);
		}
		return supplier;
	}

}
