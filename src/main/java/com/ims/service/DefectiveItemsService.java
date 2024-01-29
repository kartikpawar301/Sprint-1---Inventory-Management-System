package com.ims.service;

import java.util.List;

import com.ims.entity.DefectiveItems;
import com.ims.model.DefectiveItemsDTO;

public interface DefectiveItemsService {

	DefectiveItemsDTO addDefectiveItems(DefectiveItems defectiveItems);

	DefectiveItems getDefectiveItemsById(int defectiveItemsId);

	DefectiveItems updateDefectiveItemsDetails(DefectiveItems defectiveItems, int defectiveItemsId);

	void deleteDefectiveItems(int defectiveItemsId);
	
	List<DefectiveItemsDTO> getAllDefectiveItems();
}
