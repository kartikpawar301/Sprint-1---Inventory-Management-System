package com.ims.model;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DefectiveItemsDTO {

	private int defectiveId;
	
	@Size(max=25)
	private int defectiveQuantity;
}
