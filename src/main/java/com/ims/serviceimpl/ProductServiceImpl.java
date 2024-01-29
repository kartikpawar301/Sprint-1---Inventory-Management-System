package com.ims.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.entity.Product;
import com.ims.exception.IdNotFoundException;
import com.ims.model.ProductDTO;
import com.ims.repository.ProductRepository;
import com.ims.service.ProductService;
import com.ims.util.ProductConverter;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductConverter productConverter;
	
	@Override
	public ProductDTO addProduct(Product product) {

		productRepository.save(product);
		return productConverter.convertToProductDTO(product);
	}

	@Override
	public Product getProductById(int productId) {
	
		return productRepository.findById(productId).orElseThrow( ()-> new IdNotFoundException("Product id is not found"));
	}

	@Override
	public Product updateProductDetails(Product product, int productId) {
		
		Product updateProduct = productRepository.findById(productId).orElseThrow( ()-> new IdNotFoundException("Product id is not correct"));
		updateProduct.setProductName(product.getProductName());
		updateProduct.setProductDescription(product.getProductDescription());
		updateProduct.setProductCategory(product.getProductCategory());
		updateProduct.setProductQuantity(product.getProductQuantity());
		updateProduct.setProductPrice(product.getProductPrice());
		
		productRepository.save(updateProduct);
		
		return updateProduct;
	}

	@Override
	public void deleteProduct(int productId) {
		
		productRepository.findById(productId).orElseThrow( ()-> new IdNotFoundException("Product id is not correct"));
		productRepository.deleteById(productId);
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		
		List<Product> product = productRepository.findAll();
		
		List<ProductDTO> dtoList = new ArrayList<>();
		for(Product p: product)
		{
			dtoList.add(productConverter.convertToProductDTO(p));
		}
		return dtoList;
	}

	@Override
	public List<Product> getProductByName(String productName) {
		
		return productRepository.findProductByName(productName);
	}

	@Override
	public List<Product> getProductByCategory(String productCategory) {
		
		return productRepository.findProductByCategory(productCategory);
	}

	@Override
	public List<String> getAllProductCategory() {
		
		return productRepository.findAllProductCategory();
	}
	
}
