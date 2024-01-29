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

import com.ims.entity.DefectiveItems;
import com.ims.model.DefectiveItemsDTO;
import com.ims.service.DefectiveItemsService;
import com.ims.util.DefectiveItemsConverter;

@RestController
@RequestMapping("/ims/DefectiveItems")
@CrossOrigin(origins = "http://localhost:4200")
public class DefectiveItemsController {

	@Autowired
	DefectiveItemsService defectiveItemsService;

	@Autowired
	DefectiveItemsConverter defectiveItemsConverter;
	
	// http://localhost:8080/ims/DefectiveItems/addDefectiveItems
	@PostMapping("addDefectiveItems")
	public DefectiveItemsDTO saveDefectiveItems(@RequestBody DefectiveItemsDTO dDto) 
	{	
		DefectiveItems defectiveItems = defectiveItemsConverter.convertToEntity(dDto);
		return defectiveItemsService.addDefectiveItems(defectiveItems);
	}
	
	@GetMapping("getDefectiveItemsById/{defectiveItemsId}")
	public ResponseEntity<DefectiveItems> getDefectiveItems(@PathVariable("defectiveItemsId") int defectiveItemsId)
	{
		return new ResponseEntity<DefectiveItems>(defectiveItemsService.getDefectiveItemsById(defectiveItemsId), HttpStatus.OK);
	}
	
	@PutMapping("editDefectiveItems/{defectiveItemsId}")
	public ResponseEntity<DefectiveItems>editDefectiveItems(@PathVariable("defectiveItemsId") int defectiveItemsId, @RequestBody DefectiveItems defectiveItems)
	{
		return new ResponseEntity<DefectiveItems>(defectiveItemsService.updateDefectiveItemsDetails(defectiveItems, defectiveItemsId), HttpStatus.OK);
	}
	
	@DeleteMapping("deleteDefectiveItems/{defectiveItemsId}")
	public ResponseEntity<String> deleteDefectiveItems(@PathVariable("defectiveItemsId") int defectiveItemsId)
	{
		defectiveItemsService.deleteDefectiveItems(defectiveItemsId);
		return new ResponseEntity<String>("DefectiveItems Deleted Successfully...", HttpStatus.OK);
	}
	
	@GetMapping("getAllDefectiveItems")
	public List<DefectiveItemsDTO> getDefectiveItems() {
		
		return defectiveItemsService.getAllDefectiveItems(); 
	}
	
}
