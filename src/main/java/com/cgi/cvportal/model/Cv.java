package com.cgi.cvportal.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cvs")
public class Cv {

	//== Attributes ==
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	
	private boolean travelability;
	
	private int availability;
	
	@NotEmpty
	private String background;

	@ManyToOne
	private User user;
	
	@ManyToOne
	@NotNull
	private Language language;
	
	//@JoinColumn(name = "language_id")
    //private Long language_id;
	
	@OneToMany(mappedBy="cv",cascade=CascadeType.ALL, orphanRemoval=false, fetch=FetchType.EAGER)
	private Set<Experience> experiences;
	
	@OneToMany(mappedBy="cv",cascade=CascadeType.ALL, orphanRemoval=false, fetch=FetchType.EAGER)
	private Set<OtherExperience> otherExperiences;
	
	@OneToMany(mappedBy="cv",cascade=CascadeType.ALL, orphanRemoval=false, fetch=FetchType.EAGER)
	private Set<Education> educations;
	
	@OneToMany(mappedBy="cv",cascade=CascadeType.ALL, orphanRemoval=false, fetch=FetchType.EAGER)
	private Set<Course> courses;
	
	@OneToMany(mappedBy="cv",cascade=CascadeType.ALL, orphanRemoval=false, fetch=FetchType.EAGER)
	private Set<Certification> certifications;
	
	@OneToMany(mappedBy="cv",cascade=CascadeType.ALL, orphanRemoval=false, fetch=FetchType.EAGER)
	private Set<Competence> competences;

	//== Constructors ==
	

	//== Setters and getters ==
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public boolean isTravelability() {
		return travelability;
	}

	public void setTravelability(boolean travelability) {
		this.travelability = travelability;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(Set<Experience> experiences) {
		this.experiences = experiences;
	}

	public Set<OtherExperience> getOtherExperiences() {
		return otherExperiences;
	}

	public void setOtherExperiences(Set<OtherExperience> otherExperiences) {
		this.otherExperiences = otherExperiences;
	}

	public Set<Education> getEducations() {
		return educations;
	}

	public void setEducations(Set<Education> educations) {
		this.educations = educations;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Set<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(Set<Certification> certifications) {
		this.certifications = certifications;
	}

	public Set<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(Set<Competence> competences) {
		this.competences = competences;
	}
	
	
}
