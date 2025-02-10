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

import br.edu.ifba.demo.backend.api.dto.GeneroDTO;
import br.edu.ifba.demo.backend.api.model.GeneroModel;
import br.edu.ifba.demo.backend.api.repository.GeneroRepository;


@RestController
@RequestMapping("/genero")
public class GeneroController {


    @Autowired
    private GeneroRepository generoRepository;


    public GeneroController(GeneroRepository generoRepository){
        this.generoRepository = generoRepository;
    }


    @GetMapping
    public String teste(){


        return "Testando rota genero";
    }


    @GetMapping("/listall")
    public List<GeneroDTO> listall() {
        List<GeneroModel> generos = generoRepository.findAll();
        return generos.stream().map(GeneroDTO::converter).toList();
    }




    @GetMapping("/buscarporid/{id}")
    public GeneroModel findById(@PathVariable ("id") Long id){
        Optional<GeneroModel> genero = generoRepository.findById(id);
        if(genero.isPresent())
            return genero.get();
       
        return null;
    }


    @GetMapping("buscarpornome/{nome}")
    public GeneroModel findByNome(@PathVariable ("nome") String nome){
        Optional<GeneroModel> genero = generoRepository.findByNome(nome);
        if (genero.isPresent())
            return genero.get();
       
        return null;


    }


    @PostMapping("/salvar")
    public ResponseEntity<GeneroModel> addGenero(@RequestBody GeneroModel genero){
        GeneroModel savedGenero = generoRepository.save(genero);
        return new ResponseEntity<GeneroModel>(savedGenero, HttpStatus.CREATED);
    }


    @PutMapping("/atualizar/{id}")
    public ResponseEntity<GeneroModel> atualizarGenero
    (@PathVariable Long id, @RequestBody GeneroModel generoAtualizado){
        Optional<GeneroModel> generoExistente = generoRepository.findById(id);


        if(generoExistente.isPresent()){
            GeneroModel genero = generoExistente.get();


            genero.setNome(generoAtualizado.getNome());


            GeneroModel generoSalvo = generoRepository.save(genero);
            return ResponseEntity.ok(generoSalvo);
        }


        else{


            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/deletargenero/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable ("id") Long id){
        if(generoRepository.existsById(id)){
            generoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } 
        
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
   
}