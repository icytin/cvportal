package com.cgi.cvportal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "experiences")
public class Experience {

	//== Attributes ==
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JsonIgnore
	private Cv cv;

	//== Constructors ==
	

	//== Setters and getters ==

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cv getCv() {
		return cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}
	

}
