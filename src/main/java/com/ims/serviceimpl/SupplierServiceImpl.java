package com.ims.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.entity.Supplier;
import com.ims.exception.IdNotFoundException;
import com.ims.model.SupplierDTO;
import com.ims.repository.SupplierRepository;
import com.ims.service.SupplierService;
import com.ims.util.SupplierConverter;

@Service
public class SupplierServiceImpl implements SupplierService
{
	@Autowired
	SupplierRepository supplierRepository;
	
	@Autowired
	SupplierConverter supplierConverter;
	
	@Override
	public SupplierDTO addSupplier(Supplier supplier) 
	{
		supplierRepository.save(supplier);
		return supplierConverter.convertToSupplierDTO(supplier);
	}

	@Override
	public List<SupplierDTO> getAllSuppliers() 
	{
		List<Supplier> supplier = supplierRepository.findAll();
		
		List<SupplierDTO> dtoList = new ArrayList<>();
		for(Supplier s: supplier)
		{
			dtoList.add(supplierConverter.convertToSupplierDTO(s));
		}
		return dtoList;
	}

	@Override
	public Supplier getBySupplierId(int supplierId) 
	{
		return supplierRepository.findById(supplierId).orElseThrow( ()-> new IdNotFoundException("Supplier id is not found"));
	}

	@Override
	public Supplier updateSupplierDetails(Supplier supplier, int supplierId) 
	{
		Supplier updateSupplier = supplierRepository.findById(supplierId).orElseThrow( ()-> new IdNotFoundException("Supplier id is not correct"));
		updateSupplier.setSupplierName(supplier.getSupplierName());
		updateSupplier.setSupplierAddress(supplier.getSupplierAddress());
		updateSupplier.setSupplierMobileNumber(supplier.getSupplierMobileNumber());
		
		supplierRepository.save(updateSupplier);
		
		return updateSupplier;
		
		//supplier.setSupplierId(sId);
		//return supplierConverter.convertToSupplierDTO(supplierRepository.save(supplier));
	}

	@Override
	public void deleteSupplier(int supplierId) 
	{
		supplierRepository.findById(supplierId).orElseThrow( ()-> new IdNotFoundException("Supplier id is not correct"));
		supplierRepository.deleteById(supplierId);
	}
	
	@Override
	public List<Supplier> getSupplierByName(String supplierName) {
		
		return supplierRepository.findSupplierByName(supplierName);
	}

}
