package com.project.mod.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "payment")
@DynamicUpdate
public class Payment extends AuditModel {
	
	private static final long serialVersionUID = 1L;
	
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
	
	public Payment() {
		super();
	}

	public Payment(Integer id, String txnType, Float amount, String remarks, String mentorName, String skillName, Float totalAmountToMentor, Integer trainingId) {
		super();
		this.id = id;
		this.txnType = txnType;
		this.amount = amount;
		this.remarks = remarks;
//		this.mentorId = mentorId;
		this.mentorName = mentorName;
		this.trainingId = trainingId;
		this.skillName = skillName;
		this.totalAmountToMentor = totalAmountToMentor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

//	public Integer getMentorId() {
//		return mentorId;
//	}
//
//	public void setMentorId(Integer mentorId) {
//		this.mentorId = mentorId;
//	}

	public String getMentorName() {
		return mentorName;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	public Integer getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(Integer trainingId) {
		this.trainingId = trainingId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Float getTotalAmountToMentor() {
		return totalAmountToMentor;
	}

	public void setTotalAmountToMentor(Float totalAmountToMentor) {
		this.totalAmountToMentor = totalAmountToMentor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
