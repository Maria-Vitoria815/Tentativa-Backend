package br.edu.ifba.demo.backend.api.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id_usuario;
	
	@Column(name = "login", nullable = false, unique = true)
	private String login;
	
	@Column(name = "senha", nullable = false)
	private String senha;

	@Column(name = "create_at")
	private Timestamp create_at;

	@Column(name = "last_login", nullable = true)
	private Timestamp last_login;
    
	public UsuarioModel() {
		super();
	}

	public UsuarioModel(Long id_usuario, String login, String senha) {
		super();
		this.id_usuario = id_usuario;
		this.login = login;
		this.senha = senha;
	}

	

	public UsuarioModel(Long id_usuario, String login, String senha, Timestamp create_at, Timestamp last_login) {
		this.id_usuario = id_usuario;
		this.login = login;
		this.senha = senha;
		this.create_at = create_at;
		this.last_login = last_login;
	}

	// public Long getId_usuario() {
	// 	return id_usuario;
	// }

	// public void setId_usuario(Long id_usuario) {
	// 	this.id_usuario = id_usuario;
	// }

	// public String getLogin() {
	// 	return login;
	// }

	// public void setLogin(String login) {
	// 	this.login = login;
	// }

	// public String getSenha() {
	// 	return senha;
	// }

	// public void setSenha(String senha) {
	// 	this.senha = senha;
	// }

	// public void setCreateAt(Timestamp value) {
	// 	this.create_at = value;
	// }

	// public Timestamp getCreateAt() {
	// 	return this.create_at;
	// }

	// public void setLastLogin(Timestamp value) {
	// 	this.last_login = value;
	// }

	// public Timestamp getLastLogin() {
	// 	return this.last_login;
	// }
	
	
	
	
}
