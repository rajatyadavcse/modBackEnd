package com.project.mod.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "mentor")
@Data
public class Mentor{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //instead of name->Generator//
	private Integer id;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password") 
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "contact_number")
	private Long contactNumber;
	
	@Column(name = "reg_code")
	private String regCode = "";
	
	@Column(name = "role")
	private String role = "Mentor";
	
	@Column(name = "linkedin_url")
	private String linkedinUrl = null;
	
	@Column(name = "years_of_experience") 
	private Float yearsOfExperience;
	
	@Column(name = "active")
	private Boolean active = false;
	
	@Column(name = "confirmed_signup") 
	private Boolean confirmedSignUp = false;
	
	@Column(name = "reset_password")
	private Boolean resetPassword = false;
	
	@Column(name = "reset_password_date")
	private Date resetPasswordDate;
	
	@Column(name = "timezone")
	private String timezone;
	
	@Column(name = "rating")
	private Integer rating;
	
	@Column(name = "profile")
	private String profile=firstName;
	
	@OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL)
//	@JoinColumn(name = "id")
	private List<Training> trainings;

	@Column
	private Date createdAt;

	@Column
	private Date updatedAt;

	@PrePersist
	protected void prePersist(){
		if(this.createdAt  ==null){
			this.createdAt=new Date();
		}
		this.updatedAt=new Date();
	}
//	@OneToMany(fetch = FetchType.LAZY, mappedBy="mentor")
//	 List<Training> trainings;





}