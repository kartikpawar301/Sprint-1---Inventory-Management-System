package com.ims.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.entity.Sales;
import com.ims.exception.IdNotFoundException;
import com.ims.model.SalesDTO;
import com.ims.repository.SalesRepository;
import com.ims.service.SalesService;
import com.ims.util.SalesConverter;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	SalesRepository salesRepository;
	
	@Autowired
	SalesConverter salesConverter;
	
	@Override
	public SalesDTO addSales(Sales sales) {
		
		salesRepository.save(sales);
		return salesConverter.convertToSalesDTO(sales);
	}

	@Override
	public Sales getSalesById(int saleId) {
		
		return salesRepository.findById(saleId).orElseThrow( () -> new IdNotFoundException("Defective items id is not found"));
	}

	@Override
	public List<SalesDTO> getAllSales() {
		
		List<Sales> sales = salesRepository.findAll();
		
		List<SalesDTO> dtoList = new ArrayList<>();
		for(Sales s: sales)
		{
			dtoList.add(salesConverter.convertToSalesDTO(s));
		}
		return dtoList;
	}
	
	@Override
	public void deleteSales(int saleId) {
		
		salesRepository.findById(saleId).orElseThrow( () -> new IdNotFoundException("Sale id is not correct"));
		salesRepository.deleteById(saleId);
	}

}
