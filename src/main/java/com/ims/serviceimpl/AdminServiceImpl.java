package com.ims.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.entity.Admin;
import com.ims.exception.IdNotFoundException;
import com.ims.model.AdminDTO;
import com.ims.repository.AdminRepository;
import com.ims.service.AdminService;
import com.ims.util.AdminConverter;

@Service
public class AdminServiceImpl implements AdminService 
{
    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private AdminConverter adminConverter;

    @Override
	public AdminDTO addAdmin(Admin admin) {

		adminRepository.save(admin);
		return adminConverter.convertToAdminDTO(admin);
	}

	@Override
	public Admin getAdminById(int adminId) {
	
		return adminRepository.findById(adminId).orElseThrow( ()-> new IdNotFoundException("Admin id is not found"));
	}

	@Override
	public Admin updateAdminDetails(Admin admin, int adminId) {
		
		Admin updateAdmin = adminRepository.findById(adminId).orElseThrow( ()-> new IdNotFoundException("Admin id is not correct"));
		updateAdmin.setUsername(admin.getUsername());
		updateAdmin.setPassword(admin.getPassword());
		updateAdmin.setEmail(admin.getEmail());
		
		adminRepository.save(updateAdmin);
		
		return updateAdmin;
	}

	@Override
	public void deleteAdmin(int adminId) {
		
		adminRepository.findById(adminId).orElseThrow( ()-> new IdNotFoundException("Admin id is not correct"));
		adminRepository.deleteById(adminId);
	}

	@Override
	public List<AdminDTO> getAllAdmins() {
		
		List<Admin> admin = adminRepository.findAll();
		
		List<AdminDTO> dtoList = new ArrayList<>();
		for(Admin a: admin)
		{
			dtoList.add(adminConverter.convertToAdminDTO(a));
		}
		return dtoList;
	}
	
}
