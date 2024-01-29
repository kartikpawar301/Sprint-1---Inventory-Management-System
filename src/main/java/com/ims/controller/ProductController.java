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

import com.ims.entity.Product;
import com.ims.model.ProductDTO;
import com.ims.service.ProductService;
import com.ims.util.ProductConverter;

@RestController
@RequestMapping("/ims/Product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController 
{
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductConverter productConverter;
	
	// http://localhost:8080/ims/Product/addProduct
	@PostMapping("addProduct")
	public ProductDTO saveProduct(@RequestBody ProductDTO pDto) 
	{	
		Product product = productConverter.convertToEntity(pDto);
		return productService.addProduct(product);
	}
	
	@GetMapping("getProductById/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId)
	{
		return new ResponseEntity<Product>(productService.getProductById(productId), HttpStatus.OK);
	}
	
	@PutMapping("editProduct/{productId}")
	public ResponseEntity<Product>editProduct(@PathVariable("productId") int productId, @RequestBody Product product)
	{
		return new ResponseEntity<Product>(productService.updateProductDetails(product, productId), HttpStatus.OK);
	}
	
	@DeleteMapping("deleteProduct/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId)
	{
		productService.deleteProduct(productId);
		return new ResponseEntity<String>("Product Deleted Successfully...", HttpStatus.OK);
	}
	
	@GetMapping("getAllProduct")
	public List<ProductDTO> getProducts() {
		
		return productService.getAllProducts();
	}
	
	@GetMapping("getProductByName/{productName}")
	public List<Product> getProductByName(@PathVariable("productName") String productName) {
		
		return productService.getProductByName(productName);
	}
	
	@GetMapping("getProductByCategory/{productCategory}")
	public List<Product> getProductByCategory(@PathVariable("productCategory") String productCategory) {
		
		return productService.getProductByCategory(productCategory);
	}
	
	@GetMapping("getAllProductCategory")
	public List<String> getProductCategory() {
		
		return productService.getAllProductCategory();
	}
	
}
