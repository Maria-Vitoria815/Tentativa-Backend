package br.edu.ifba.demo.backend.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.demo.backend.api.repository.UsuarioRepository;
import br.edu.ifba.demo.backend.api.model.UsuarioModel;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	private UsuarioRepository usuRepository;
	
	public UsuarioController(UsuarioRepository usuRepository) {
		super();
		this.usuRepository = usuRepository;
	}

	@GetMapping
	public String teste() {
		return "Testando Rota Usuario";
	}
	
	// Método que retornar todos os usuarios do banco de dados
	@GetMapping("/listall")
	public List<UsuarioModel> listall() {
		var usuarios = usuRepository.findAll();
		return usuarios;
	}

	// Método que retornar o usuario associado ao ID passado como parametro
	@GetMapping("/{id}")
    public UsuarioModel findById(@PathVariable("id") Long id) {
		Optional<UsuarioModel> usuario = usuRepository.findById(id);
		if ( usuario.isPresent() )
			return usuario.get();
        return null;
    }

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	  // Método para adicionar um novo usuário
	  @PostMapping
	  public ResponseEntity<UsuarioModel> addUsuario(@RequestBody UsuarioModel usuario) {
		  UsuarioModel savedUsuario = usuRepository.save(usuario);
		  return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
	  }
}