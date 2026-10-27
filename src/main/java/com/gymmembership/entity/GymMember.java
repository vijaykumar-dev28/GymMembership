package com.gymmembership.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="GymMembers")
public class GymMember {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="Name can't be empty!")
	private String name;
	
	@NotBlank(message="Email can't be empty!")
	@Email(message="Invalid email type!")
	private String email;
	
	@NotBlank(message="Phone can't be empty!")
	private String phone;
	
	@NotBlank(message="Membership can't be empty so select one!")
	private String membership;
	
	@NotNull(message="fee shouldn't be null")
	private Double fee;
	
	@CreationTimestamp
	private LocalDate joinDate;
	
}
