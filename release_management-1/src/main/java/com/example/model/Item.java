package com.example.model;

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
@Table(name="Item")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="itemId")
	private int itemId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="releaseID")
	private int release;

	public Item() {
		// TODO Auto-generated constructor stub
	}
	


	public Item(String name, int release) {
		super();
		this.name = name;
		this.release = release;
	}

	public void setRelease(int release) {
		this.release = release;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getRelease() {
		return release;
	}



	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", release=" + release + "]";
	}
	
	
}
