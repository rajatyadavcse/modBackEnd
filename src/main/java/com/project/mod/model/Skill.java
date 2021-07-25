package com.project.mod.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="skill")
@Data
public class Skill{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "name", nullable = false)
	private String name;
	
	@Column (name = "toc", nullable = false)
	private String toc;
	
	@Column(name = "prerequisites", nullable = false)
	private String prerequisites;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="skill")
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
