package br.edu.ifba.demo.backend.api.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.demo.backend.api.model.GeneroModel;
import br.edu.ifba.demo.backend.api.model.LivroModel;
import br.edu.ifba.demo.backend.api.repository.GeneroRepository;
import br.edu.ifba.demo.backend.api.repository.LivroRepository;


@RestController
@RequestMapping("/livro")
public class LivroController {
   
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private GeneroRepository generoRepository;
   
    public LivroController(LivroRepository livroRepository, GeneroRepository generoRepository) {
        this.livroRepository = livroRepository;
        this.generoRepository = generoRepository;
    }


    //teste de rota
    @GetMapping
    public String teste(){


        return "Testando Rota Livros";


    }


    // Método que retornar todos os livros do banco de dados
    @GetMapping("/listall")
    public List <LivroModel> listall(){


        var livro = livroRepository.findAll();
        return livro;
       
    }


    // Método que retornar o usuario associado ao ID passado como parametro
    @GetMapping("/buscarporid/{id}")
    public LivroModel findById(@PathVariable ("id") Long id){
        Optional<LivroModel> livro = livroRepository.findById(id);
        if(livro.isPresent())
            return livro.get();
       
        return null;


    }


    // Método que retornar o usuario associado ao titulo passado como parametro
    @GetMapping("/buscarportitulo/{titulo}")
    public LivroModel findByTitulo(@PathVariable("titulo") String titulo) {
        Optional<LivroModel> livro = livroRepository.findByTitulo(titulo);
        if (livro.isPresent())
            return livro.get();
       
        return null;
    }


    // Método que retornar o usuario associado ao isbn passado como parametro
    @GetMapping("/buscarporisbn/{isbn}")
    public LivroModel findByIsbn(@PathVariable("isbn") String isbn) {
        Optional<LivroModel> livro = livroRepository.findByIsbn(isbn);
        if (livro.isPresent())
            return livro.get();
       
        return null;
    }


    // Método para deletar pelo ID
    @DeleteMapping("/deletelivro/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 Not Found
        }
    }


    @PostMapping("/salvar")
    public ResponseEntity<LivroModel> addLivro(@RequestBody LivroModel livro) {
        if (livro.getGenero() != null && livro.getGenero().getId_genero() != null) {
            Optional<GeneroModel> generoOpt = generoRepository.findById(livro.getGenero().getId_genero());
            if (generoOpt.isPresent()) {
                livro.setGenero(generoOpt.get());
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        }
       
        LivroModel savedLivro = livroRepository.save(livro);
        return new ResponseEntity<>(savedLivro, HttpStatus.CREATED);
    }




    @PutMapping("/atualizar/{id}")
    public ResponseEntity<LivroModel> atualizarLivro(@PathVariable Long id, @RequestBody LivroModel livroAtualizado) {
        Optional<LivroModel> livroExistente = livroRepository.findById(id);
       
        if (livroExistente.isPresent()) {
            LivroModel livro = livroExistente.get();
           
            // Atualizando os campos do livro existente
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setEditora(livroAtualizado.getEditora());
            livro.setAno_publicacao(livroAtualizado.getAno_publicacao());
            livro.setIsbn(livroAtualizado.getIsbn());
            livro.setNum_paginas(livroAtualizado.getNum_paginas());
            livro.setSinopse(livroAtualizado.getSinopse());
            livro.setIdioma(livroAtualizado.getIdioma());
            livro.setPreco(livroAtualizado.getPreco());


            // Garantindo que o gênero exista no banco antes de atualizar
            if (livroAtualizado.getGenero() != null && livroAtualizado.getGenero().getId_genero() != null) {
                Optional<GeneroModel> generoOpt = generoRepository.findById(livroAtualizado.getGenero().getId_genero());
                if (generoOpt.isPresent()) {
                    livro.setGenero(generoOpt.get());
                } else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
                }
            }


            // Salvando no banco de dados
            LivroModel livroSalvo = livroRepository.save(livro);
            return ResponseEntity.ok(livroSalvo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 caso não encontre o livro
        }
    }  


}
