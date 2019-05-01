package com.example.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Release_management") 
public class Release implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="releaseId")
	private int releaseId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="startDate")
	private Date startDate;
	
	@Column(name="plannedDate")
	private Date plannedDate;
	
	@Column(name="releaseDate")
	private Date releaseDate;
	
	@Column(name="type")
	private String type;
	
	@Column(name="stage")
	private String stage;
	
	@Column(name="status")
	private String status;
	
	@Column(name="manager")
	private String manager;
	
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="version")
	private int version;

	public Release() {
		//this.manager = "Dev PM";
	}


	public Release(String title, String description, Date startDate, Date plannedDate, Date releaseDate, String type,
			String stage, String status, String manager) {
		super();
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.plannedDate = plannedDate;
		this.releaseDate = releaseDate;
		this.type = type;
		this.stage = stage;
		this.status = status;
		this.manager = manager;

	}


	public int getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(int releaseId) {
		this.releaseId = releaseId;
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

	public Date getPlannedDate() {
		return plannedDate;
	}

	public void setPlannedDate(Date plannedDate) {
		this.plannedDate = plannedDate;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version++;
	}


	public String getManager() {
		return manager;
	}


	public void setManager(String manager) {
		this.manager = manager;
	}


	@Override
	public String toString() {
		return "Release [releaseId=" + releaseId + ", title=" + title + ", description=" + description + ", startDate="
				+ startDate + ", plannedDate=" + plannedDate + ", releaseDate=" + releaseDate + ", type=" + type
				+ ", stage=" + stage + ", status=" + status + ", manager=" + manager
				+ ", version=" + version + "]";
	}
}
