package com.project.mod.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {
	
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
	@SequenceGenerator(name="seq", initialValue=101, allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator="seq")
	private Integer regCode;
	
	@Column(name = "role")
	private String role = "User";
	
	@Column(name = "linkedin_url")
	private String linkedinUrl = null;
	
	@Column(name = "years_of_experience") 
	private Float yearsOfExperience;
	
	@Column(name = "active")
	private Boolean active =true;
	
	@Column(name = "confirmed_signup") 
	private Boolean confirmedSignUp = true;
	
	@Column(name = "reset_password")
	private Boolean resetPassword = false;
	
	@Column(name = "reset_password_date")
	private Date resetPasswordDate;
	
//	@ManyToOne(cascade = CascadeType.ALL)
////	@JoinColumn(name = "id")
//	private Training training;
//	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "user")
	List<Training> trainings;
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
	
}