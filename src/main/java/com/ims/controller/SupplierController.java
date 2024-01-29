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


import com.ims.entity.Supplier;
import com.ims.model.SupplierDTO;
import com.ims.service.SupplierService;
import com.ims.util.SupplierConverter;

@RestController
@RequestMapping("/ims/Supplier")
@CrossOrigin(origins = "http://localhost:4200")
public class SupplierController 
{
	@Autowired
	SupplierService supplierService;
	
	@Autowired
	SupplierConverter supplierConverter;
	
	// http://localhost:8080/ims/Supplier/addSupplier
	@PostMapping("addSupplier")
	public SupplierDTO saveSupplier(@RequestBody SupplierDTO sDto) 
	{	
		Supplier supplier = supplierConverter.convertToEntity(sDto);
		return supplierService.addSupplier(supplier);
	}
	
	@GetMapping("getAllSupplier")
	public List<SupplierDTO> getAllSupplier() 
	{	
		return supplierService.getAllSuppliers();
	}
	
	@GetMapping("getSupplierById/{supplierId}")
	public ResponseEntity<Supplier> getSupplier(@PathVariable("supplierId") int supplierId)
	{
		return new ResponseEntity<Supplier>(supplierService.getBySupplierId(supplierId), HttpStatus.OK);
	}
	
	@PutMapping("editSupplier/{supplierId}")
	public ResponseEntity<Supplier>editSupplier(@PathVariable("supplierId") int supplierId, @RequestBody Supplier supplier)
	{
		return new ResponseEntity<Supplier>(supplierService.updateSupplierDetails(supplier, supplierId), HttpStatus.OK);
	}
	
	@DeleteMapping("deleteSupplier/{supplierId}")
	public ResponseEntity<String> deleteSupplier(@PathVariable("supplierId") int supplierId)
	{
		supplierService.deleteSupplier(supplierId);
		return new ResponseEntity<String>("Supplier Deleted Successfully...", HttpStatus.OK);
	}
	
	@GetMapping("getSupplierByName/{supplierName}")
	public List<Supplier> getSupplierByName(@PathVariable("supplierName") String supplierName) {
		
		return supplierService.getSupplierByName(supplierName);
	}

}