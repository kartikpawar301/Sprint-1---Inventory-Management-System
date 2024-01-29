package com.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ims.entity.DefectiveItems;

@Repository
public interface DefectiveItemsRepository extends JpaRepository<DefectiveItems, Integer> {

	
}
