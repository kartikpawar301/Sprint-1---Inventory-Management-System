package com.ims.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ims.entity.Product;
import com.ims.model.ProductDTO;

@Component
public class ProductConverter 
{
	// Converting Product Entity to Product DTO
	public ProductDTO convertToProductDTO(Product product)
	{
		ProductDTO pDto = new ProductDTO();
		if(product!=null)
			{
				BeanUtils.copyProperties(product, pDto);
			}
		return pDto;
	}
			
	// Converting Product DTO to Product Entity
	public Product convertToEntity(ProductDTO pDto)
	{
		Product product = new Product();
		if(pDto!=null)
		{
			BeanUtils.copyProperties(pDto, product);
		}
		return product;
	}

}
