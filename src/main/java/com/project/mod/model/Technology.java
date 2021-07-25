package com.project.mod.model;
import lombok.Data;

import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="technology")
@Data
public class Technology{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="tech_name",nullable=false)
	private String techName;
	
	@Column(name="price",nullable=false)
	private Float price;
	
	@Column(name="duration",nullable=false)
	private String duration;
	
	@Column(name="remarks",nullable=false)
	private String remarks;
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy="technology")
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
}
