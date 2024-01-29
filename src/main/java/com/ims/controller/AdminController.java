package com.ims.controller; //(for admin-specific operations)

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

import com.ims.entity.Admin;
import com.ims.model.AdminDTO;
import com.ims.service.AdminService;
import com.ims.util.AdminConverter;

@RestController
@RequestMapping("/ims/Admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController 
{
    @Autowired
    AdminService adminService;
    
    @Autowired
    AdminConverter adminConverter;
    
    // http://localhost:8080/ims/Admin/addAdmin
 	@PostMapping("addAdmin")
 	public AdminDTO saveAdmin(@RequestBody AdminDTO aDto) 
 	{	
 		Admin admin = adminConverter.convertToAdminEntity(aDto);
 		return adminService.addAdmin(admin);
 	}
 	
 	@GetMapping("getAdmin/{adminId}")
 	public ResponseEntity<Admin> getAdmin(@PathVariable("adminId") int adminId)
 	{
 		return new ResponseEntity<Admin>(adminService.getAdminById(adminId), HttpStatus.OK);
 	}
 	
 	@PutMapping("updateAdmin/{adminId}")
 	public ResponseEntity<Admin>editAdmin(@PathVariable("adminId") int adminId, @RequestBody Admin admin)
 	{
 		return new ResponseEntity<Admin>(adminService.updateAdminDetails(admin, adminId), HttpStatus.OK);
 	}
 	
 	@DeleteMapping("deleteAdmin/{adminId}")
 	public ResponseEntity<String> deleteAdmin(@PathVariable("adminId") int adminId)
 	{
 		adminService.deleteAdmin(adminId);
 		return new ResponseEntity<String>("Admin Deleted Successfully...", HttpStatus.OK);
 	}
 	
 	@GetMapping("getAllAdmin")
 	public List<AdminDTO> getAdmins() {
 		
 		return adminService.getAllAdmins();
 	}
 	
}
