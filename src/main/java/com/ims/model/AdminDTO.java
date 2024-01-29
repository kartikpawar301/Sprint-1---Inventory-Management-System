package com.ims.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AdminDTO 
{
	private int adminId;

    @Size(max=25)
    @NotBlank(message="Admin username cannot be blank")
    private String username;

    @Size(max=15)
    @NotBlank(message="Admin password cannot be blank")
    private String password;

    @Size(max=25)
    @NotBlank(message="Admin email cannot be blank")
    private String email;

}
