package com.ims.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ims.entity.Admin;
import com.ims.model.AdminDTO;

@Component
public class AdminConverter 
{
	public AdminDTO convertToAdminDTO(Admin admin) 
	{
        AdminDTO aDto = new AdminDTO();
        if(admin != null) 
        {
        	BeanUtils.copyProperties(admin, aDto);
            // Map other fields as needed
        }
        return aDto;
    }

    public Admin convertToAdminEntity(AdminDTO aDto) 
    {
        Admin admin = new Admin();
        if(aDto != null) 
        {
        	BeanUtils.copyProperties(aDto, admin);
            // Map other fields as needed
        }
        return admin;
    }
   
    /*public List<AdminDTO> convertToAdminDTOList(List<Admin> admins) 
    {
    	return admins.stream().map(this::convertToAdminDTO).collect(Collectors.toList());
    }
    */
}
