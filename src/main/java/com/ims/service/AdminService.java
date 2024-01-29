package com.ims.service;

import java.util.List;

import com.ims.entity.Admin;
import com.ims.model.AdminDTO;

public interface AdminService 
{
	AdminDTO addAdmin(Admin admin);
	
    Admin getAdminById(int id);
    
    Admin updateAdminDetails(Admin admin, int id);
    
    void deleteAdmin(int id);
    
    List<AdminDTO> getAllAdmins();
}
