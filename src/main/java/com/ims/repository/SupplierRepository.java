package com.ims.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ims.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>
{
	@Query("Select s from Supplier s where s.supplierName=?1")
	List<Supplier> findSupplierByName(String supplierName);
}
