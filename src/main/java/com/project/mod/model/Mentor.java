package com.project.mod.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "mentor")
public class Mentor extends AuditModel{
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


//	@OneToMany(fetch = FetchType.LAZY, mappedBy="mentor")
//	 List<Training> trainings;

	public Mentor() {
		super();
	}

	public Mentor(Integer id, String userName, String password, String firstName, String lastName, Long contactNumber, String regCode,
			String role, String linkedinUrl, Float yearsOfExperience, Boolean active, Boolean confirmedSignUp,
			Boolean resetPassword, Date resetPasswordDate, String timezone, Integer rating, String profile) {
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
		this.timezone = timezone;
		this.rating = rating;
		this.profile = profile;
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

	public String getRegCode() {
		return regCode;
	}

	public void setRegCode(String regCode) {
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

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	

	
}