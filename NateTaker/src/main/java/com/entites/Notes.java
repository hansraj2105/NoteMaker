package com.entites;

import java.util.Date;
import java.util.Random;

import javax.persistence.*;


@Entity
@Table(name="notes")
public class Notes {

	@Id
	private int id;
	private String title;
	private String contant;
	private Date addedDate;
	public Notes( String title, String contant, Date addedDate) {
		super();
		this.id = new Random().nextInt(100000);
		this.title = title;
		this.contant = contant;
		this.addedDate = addedDate;
	}
	public Notes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContant() {
		return contant;
	}
	public void setContant(String contant) {
		this.contant = contant;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	
	
	
	
}
