package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table
public class Iteration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="iterationId")
	private int iterationId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="startDate")
	private Date startDate;
	
	@Column(name="endDate")
	private Date endDate;
	
	@Column(name="status")
	private String status;
	
	@Column(name="type")
	private String type;
	
	@Column(name="releaseId")
	private int release;

	
	public Iteration() {
		// TODO Auto-generated constructor stub
	}

	public Iteration(String title, String description, Date startDate, Date endDate, String status,
			String type, int release) {
		super();
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.type = type;
		this.release = release;
	}

	public int getRelease() {
		return release;
	}


	public void setRelease(int release) {
		this.release = release;
	}


	public int getIterationId() {
		return iterationId;
	}

	public void setIterationId(int iterationId) {
		this.iterationId = iterationId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
