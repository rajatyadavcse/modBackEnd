package com.project.mod.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="training")
@Data
public class Training{
	
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
