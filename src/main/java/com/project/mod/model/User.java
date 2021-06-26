package com.project.mod.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends AuditModel {
	
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
	
	public User() {
		super();
	}

	public User(Integer id, String userName, String password, String firstName, String lastName, Long contactNumber, Integer regCode,
			String role, String linkedinUrl, Float yearsOfExperience, Boolean active, Boolean confirmedSignUp,
			Boolean resetPassword, Date resetPasswordDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.regCode = regCode;
		this.role = role;
		this.linkedinUrl = linkedinUrl;
		this.yearsOfExperience = yearsOfExperience;
		this.active = active;
		this.confirmedSignUp = confirmedSignUp;
		this.resetPassword = resetPassword;
		this.resetPasswordDate = resetPasswordDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Integer getRegCode() {
		return regCode;
	}

	public void setRegCode(Integer regCode) {
		this.regCode = regCode;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLinkedinUrl() {
		return linkedinUrl;
	}

	public void setLinkedinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	}

	public Float getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(Float yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getConfirmedSignUp() {
		return confirmedSignUp;
	}

	public void setConfirmedSignUp(Boolean confirmedSignUp) {
		this.confirmedSignUp = confirmedSignUp;
	}

	public Boolean getResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(Boolean resetPassword) {
		this.resetPassword = resetPassword;
	}

	public Date getResetPasswordDate() {
		return resetPasswordDate;
	}

	public void setResetPasswordDate(Date resetPasswordDate) {
		this.resetPasswordDate = resetPasswordDate;
	}
	
	
}