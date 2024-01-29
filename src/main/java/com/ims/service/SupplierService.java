package com.ims.service;

import java.util.List;

import com.ims.entity.Supplier;
import com.ims.model.SupplierDTO;

public interface SupplierService 
{
	SupplierDTO addSupplier(Supplier supplier);
	
	List<SupplierDTO> getAllSuppliers();
	
	Supplier getBySupplierId(int supplierId);
	
	Supplier updateSupplierDetails(Supplier supplier, int supplierId);
	
	void deleteSupplier(int supplierId);
	
	List<Supplier> getSupplierByName(String supplierName);
}
