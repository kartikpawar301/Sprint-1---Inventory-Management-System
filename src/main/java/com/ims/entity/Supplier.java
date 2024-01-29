package com.ims.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplierId;
	
	@Column(length=25, nullable = false)
	@NotBlank(message="Supplier name cannot be blank")
	private String supplierName;
	
	@Column(length=25, nullable = false)
	@NotBlank(message="Supplier address cannot be blank")
	private String supplierAddress;
	
	@Column(length=10, nullable = false, unique=true)
	@NotNull(message="Supplier mobile number cannot be null")
	private long supplierMobileNumber;
	
	@ManyToMany(mappedBy="supplier", fetch = FetchType.LAZY)
	private List<Product> product;
	
	@OneToMany(mappedBy = "supplier")
	private List<DefectiveItems> defectiveItems;
}
