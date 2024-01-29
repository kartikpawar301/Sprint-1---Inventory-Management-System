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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ims.entity.Sales;
import com.ims.model.SalesDTO;
import com.ims.service.SalesService;
import com.ims.util.SalesConverter;

@RestController
@RequestMapping("/ims/Sales")
@CrossOrigin(origins = "http://localhost:4200")
public class SalesController {

	@Autowired
	SalesService salesService;
	
	@Autowired
	SalesConverter salesConverter;
	
	// http://localhost:8080/ims/Sales/addSales
	@PostMapping("addSales")
	public SalesDTO saveSales(@RequestBody SalesDTO s1Dto) 
	{	
		Sales sales = salesConverter.convertToEntity(s1Dto);
		return salesService.addSales(sales);
	}
	
	@GetMapping("getSalesById/{saleId}")
	public ResponseEntity<Sales> getSales(@PathVariable("saleId") int saleId)
	{
		return new ResponseEntity<Sales>(salesService.getSalesById(saleId), HttpStatus.OK);
	}
	
	@GetMapping("getAllSales")
	public List<SalesDTO> getAllSales()
	{
		return salesService.getAllSales();
	}
	
	@DeleteMapping("deleteSales/{saleId}")
	public ResponseEntity<String> deleteSales(@PathVariable("saleId") int saleId)
	{
		salesService.deleteSales(saleId);
		return new ResponseEntity<String>("Sales Deleted Successfully...", HttpStatus.OK);
	}
	
}
