package com.ims.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ims.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{
	@Query("Select p from Product p where p.productName=?1")
	List<Product> findProductByName(String productName);
	
	@Query("Select p1 from Product p1 where p1.productCategory=?1")
	List<Product> findProductByCategory(String productCategory);
	
	@Query("select distinct p2.productCategory from Product p2")
	List<String> findAllProductCategory();
}
