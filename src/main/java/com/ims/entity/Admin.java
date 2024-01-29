package com.ims.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;

    @Column(length=25, nullable = false)
    @NotBlank(message="Admin username cannot be blank")
    private String username;

    @Column(length=15, nullable = false)
    @NotBlank(message="Admin password cannot be blank")
    private String password;

    @Column(length=25, nullable = false)
    @NotBlank(message="Admin email cannot be blank")
    private String email;
  
}
