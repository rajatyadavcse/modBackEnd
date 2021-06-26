package com.project.mod.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DynamicUpdate
public class Training extends AuditModel {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "_id")
	private Integer id;
	
	@Column(name = "status")
	private String status = "Current";
	
	@Column(name = "progress")
	private Integer progress = 0;
	
	@Column(name = "fees")
	private Float fees = 0.0f;
	
	@Column(name = "commision_amount")
	private Float commisionAmount = 0.0f;
	
	@Column(name = "rating")
	private Integer rating = 0;
	
//	@JsonFormat(pattern = "yyy-MM-dd")
	@Column(name = "start_date")
	private Date startDate = new Date();
	
//	@JsonFormat(pattern = "yyy-MM-dd")
	@Column(name = "end_date")
	private Date endDate = new Date();
	
	@JsonFormat(pattern = "HH:mm:ss")
	@Column(name = "start_time")
	private String startTime;
	
	@JsonFormat(pattern = "HH:mm:ss")
	@Column(name = "end_time")
	private String endTime;
	
	@Column(name = "amount_recieved")
	private Float amountRecieved = 0.0f;
	
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static String randomAlphaNumeric(int count) {
	StringBuilder builder = new StringBuilder();
	while (count-- != 0) {
	int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
	builder.append(ALPHA_NUMERIC_STRING.charAt(character));
	}
	return builder.toString();
	}
	
	@Column(name = "razorpay_payment_id")
	private String razorPaymentId = randomAlphaNumeric(10);
	
	//many mentors to single user
	@ManyToOne(cascade = CascadeType.ALL)
	private Mentor mentor;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "training_user", joinColumns = {
			@JoinColumn(name = "training_id", nullable = false, updatable = false)
	},
	inverseJoinColumns = {
			@JoinColumn(name = "user_id", nullable = false, updatable = false)
	}
	)
	private List<User> user;
	

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "training_skill", joinColumns = { 
			@JoinColumn(name = "training_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "skill_id", 
					nullable = false, updatable = false) })
	private List<Skill> skill;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Technology technology;

	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "training_payment", joinColumns = { 
			@JoinColumn(name = "training_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "payment_id", 
					nullable = false, updatable = false) })
	private List<Payment> payment;
	
	public Training() {
		super();
	}

	public Training(Integer id, String status, Integer progress, Float fees, Float commisionAmount, Integer rating,
			Date startDate, Date endDate, String startTime, String endTime, Float amountRecieved,
			String razorPaymentId, Mentor mentor, List<User> user, List<Skill> skill, Technology technology,
			List<Payment> payment) {
		super();
		this.id = id;
		this.status = status;
		this.progress = progress;
		this.fees = fees;
		this.commisionAmount = commisionAmount;
		this.rating = rating;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.amountRecieved = amountRecieved;
		this.razorPaymentId = razorPaymentId;
		this.mentor = mentor;
		this.user = user;
		this.skill = skill;
		this.technology = technology;
		this.payment = payment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getProgress() {
		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	public Float getFees() {
		return fees;
	}

	public void setFees(Float fees) {
		this.fees = fees;
	}

	public Float getCommisionAmount() {
		return commisionAmount;
	}

	public void setCommisionAmount(Float commisionAmount) {
		this.commisionAmount = commisionAmount;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Float getAmountRecieved() {
		return amountRecieved;
	}

	public void setAmountRecieved(Float amountRecieved) {
		this.amountRecieved = amountRecieved;
	}

	public String getRazorPaymentId() {
		return razorPaymentId;
	}

	public void setRazorPaymentId(String razorPaymentId) {
		this.razorPaymentId = razorPaymentId;
	}

	public Mentor getMentor() {
		return mentor;
	}

	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Skill> getSkill() {
		return skill;
	}

	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getAlphaNumericString() {
		return ALPHA_NUMERIC_STRING;
	}

			
}
