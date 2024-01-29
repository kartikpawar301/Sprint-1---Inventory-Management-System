package com.ims.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ims.entity.DefectiveItems;
import com.ims.model.DefectiveItemsDTO;

@Component
public class DefectiveItemsConverter 
{
	// Converting DefectiveItems Entity to DefectiveItems DTO
	public DefectiveItemsDTO convertToDefectiveItemsDTO(DefectiveItems defectiveItems)
	{
		DefectiveItemsDTO dDto = new DefectiveItemsDTO();
		if(defectiveItems!=null)
			{
				BeanUtils.copyProperties(defectiveItems, dDto);
			}
		return dDto;
	}
			
	// Converting DefectiveItems DTO to DefectiveItems Entity
	public DefectiveItems convertToEntity(DefectiveItemsDTO dDto)
	{
		DefectiveItems defectiveItems = new DefectiveItems();
		if(dDto!=null)
		{
			BeanUtils.copyProperties(dDto, defectiveItems);
		}
		return defectiveItems;
	}

}
