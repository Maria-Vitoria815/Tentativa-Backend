package br.edu.ifba.demo.backend.api.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.demo.backend.api.model.UsuarioModel;

public class UsuarioDTO {

    private long id_usuario;
    private String login;
    private String senha;
    private LocalDateTime create_at;
    private LocalDateTime last_login;

    public static UsuarioDTO converter(UsuarioModel usuarioModel) {
        var usuario = new UsuarioDTO();
        usuario.setId_usuario(usuarioModel.getId_usuario());
        usuario.setLogin(usuarioModel.getLogin());
        usuario.setSenha(usuarioModel.getSenha());
        usuario.setCreate_at(usuarioModel.getCreateAt());
        usuario.setLast_login(usuarioModel.getLastLogin());
        return usuario;
    }

    public static List<UsuarioDTO> converter(List<UsuarioModel> usuarios) {
        List<UsuarioDTO> list = new ArrayList<>();
        for (UsuarioModel model : usuarios) {
            list.add(UsuarioDTO.converter(model));
        }
        return list;
    }

    public UsuarioDTO() {
        super();
    }

    public UsuarioDTO(long id_usuario, String login, String senha) {
        super();
        this.id_usuario = id_usuario;
        this.login = login;
        this.senha = senha;
    }

    public UsuarioDTO(long id_usuario, String login, String senha, LocalDateTime create_at, LocalDateTime last_login) {
        this.id_usuario = id_usuario;
        this.login = login;
        this.senha = senha;
        this.create_at = create_at;
        this.last_login = last_login;
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
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

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDateTime create_at) {
        this.create_at = create_at;
    }

    public LocalDateTime getLast_login() {
        return last_login;
    }

    public void setLast_login(LocalDateTime last_login) {
        this.last_login = last_login;
    }
}
