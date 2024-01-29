package com.ims.service;

import java.util.List;

import com.ims.entity.Product;
import com.ims.model.ProductDTO;

public interface ProductService 
{
	ProductDTO addProduct(Product product);

	Product getProductById(int productId);

	Product updateProductDetails(Product product, int productId);

	void deleteProduct(int productId);
	
	List<ProductDTO> getAllProducts();
	
	List<Product> getProductByName(String productName);
	
	List<Product> getProductByCategory(String productCategory);
	
	List<String> getAllProductCategory();
	
}
