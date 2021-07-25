package com.project.mod.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "payment")
@Data
public class Payment{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "txn_type", nullable = false)
	private String txnType="Online";
	
	@Column (name = "amount", nullable = false)
	private Float amount;
	
	@Column (name = "remarks", nullable = false)
	private String remarks;
	
//	@Column (name = "mentor_id", nullable = false)
//	private Integer mentorId;
	
	@Column (name = "mentor_name", nullable = false)
	private String mentorName;
	
	@Column (name = "training_id", nullable = true)
	private Integer trainingId;
	
	@Column (name = "skill_name", nullable = false)
	private String skillName;
	
	@Column (name = "total_amount_to_mentor", nullable = false)
	private Float totalAmountToMentor = 0.0f;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy="payment")
	private List<Training> training;
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
