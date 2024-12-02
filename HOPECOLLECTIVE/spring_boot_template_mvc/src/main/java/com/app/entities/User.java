package com.app.entities;

import java.util.List;

import javax.persistence.*;
//import javax.persistence.Entity;
//import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, unique = true)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String name;
	
	@Enumerated(EnumType.STRING)//Maps as String
	private Role role;
	
	@OneToMany(mappedBy= "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Campaign> campaings;
	
	@OneToMany(mappedBy= "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Donation> donations;

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", role=" + role
				+ ", campaings=" + campaings + ", donations=" + donations + "]";
	}
	
	//getter and setter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Campaign> getCampaings() {
		return campaings;
	}

	public void setCampaings(List<Campaign> campaings) {
		this.campaings = campaings;
	}

	public List<Donation> getDonations() {
		return donations;
	}

	public void setDonations(List<Donation> donations) {
		this.donations = donations;
	}
	
	
	
}
