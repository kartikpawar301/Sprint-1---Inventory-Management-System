package com.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ims.entity.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer> {

	
}
