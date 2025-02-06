package br.edu.ifba.demo.backend.api.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifba.demo.backend.api.model.UsuarioModel;

public class UsuarioDTO implements Serializable {

	private Long id_usuario;
	private String login;
	private String senha;
	private Timestamp create_at;
	private Timestamp last_login;

	public static UsuarioDTO converter(UsuarioModel usuarioModel) {
		var usuario = new UsuarioDTO();
		usuario.setId_usuario( usuarioModel.getId_usuario() );
		usuario.setLogin( usuarioModel.getLogin() );
		usuario.setSenha( usuarioModel.getSenha() );
		usuario.setCreate_at( usuarioModel.getCreate_at() );
		usuario.setLast_login( usuarioModel.getLast_login() );
		return usuario;
	}
	
	public static List<UsuarioDTO> converter(List<UsuarioModel> usuarios) {
		List<UsuarioDTO> list=new ArrayList<UsuarioDTO>();
		
		for (UsuarioModel model : usuarios) {
			list.add( UsuarioDTO.converter(model)) ;
		}
		return list;
		// return clientes.stream().map( Cliente :: converter).collect(Collectors.toList());
	}
	
	
	public UsuarioDTO() {
		super();
	}
	
	
	
	public UsuarioDTO(Long id_usuario, String login, String senha) {
		super();
		this.id_usuario = id_usuario;
		this.login = login;
		this.senha = senha;
	}

	public UsuarioDTO(Long id_usuario, String login, String senha, Timestamp create_at, Timestamp last_login) {
		this.id_usuario = id_usuario;
		this.login = login;
		this.senha = senha;
		this.create_at = create_at;
		this.last_login = last_login;
	}
	
	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Timestamp getCreate_at() {
		return create_at;
	}


	public Timestamp getLast_login() {
		return last_login;
	}


	public void setCreate_at(Timestamp create_at) {
		this.create_at = create_at;
	}


	public void setLast_login(Timestamp last_login) {
		this.last_login = last_login;
	}

	
}
