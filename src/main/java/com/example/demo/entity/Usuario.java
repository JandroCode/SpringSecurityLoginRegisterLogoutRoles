package com.example.demo.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String email;
	private boolean enabled;
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfiles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}
	
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Usuario(Long id, String username, String email, boolean enabled, List<Perfil> perfiles, String password) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.enabled = enabled;
		this.perfiles = perfiles;
		this.password = password;
	}

	public Usuario() {}
	
	public void addPerfil(Perfil tmpPerfil) {
		perfiles = new LinkedList<>();
		perfiles.add(tmpPerfil);
		
	}
	
	
		
	

}
