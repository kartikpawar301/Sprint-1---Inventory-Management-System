package com.ims.service;

import java.util.List;

import com.ims.entity.Sales;
import com.ims.model.SalesDTO;

public interface SalesService {

	SalesDTO addSales(Sales sales);
	
	Sales getSalesById(int saleId);
	
	List<SalesDTO> getAllSales();
	
	void deleteSales(int saleId);
}
