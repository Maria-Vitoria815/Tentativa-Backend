package br.edu.ifba.demo.backend.api.model;

import java.time.LocalDateTime;

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
    private long id_usuario;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "create_at", insertable = false, updatable = false)
    private LocalDateTime create_at;

    @Column(name = "last_login", nullable = true)
    private LocalDateTime last_login;

    public UsuarioModel() {
        super();
    }

    public UsuarioModel(long id_usuario, String login, String senha) {
        super();
        this.id_usuario = id_usuario;
        this.login = login;
        this.senha = senha;
    }

    public UsuarioModel(long id_usuario, String login, String senha, LocalDateTime create_at, LocalDateTime last_login) {
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

    public LocalDateTime getCreateAt() {
        return this.create_at;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.create_at = createAt;
    }

    public LocalDateTime getLastLogin() {
        return this.last_login;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.last_login = lastLogin;
    }
}
