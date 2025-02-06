package br.edu.ifba.demo.backend.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifba.demo.backend.api.model.LivroModel;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Long> {

    //Metodo pra buscar por titulo 
    Optional<LivroModel> findByTitulo(String titulo);
    //Metodo pra buscar por isbn 
    Optional<LivroModel> findByIsbn(String isbn);
}
