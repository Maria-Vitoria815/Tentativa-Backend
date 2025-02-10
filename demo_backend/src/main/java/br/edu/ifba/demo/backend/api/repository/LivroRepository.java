package br.edu.ifba.demo.backend.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifba.demo.backend.api.model.LivroModel;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Long> {

 
    Optional<LivroModel> findByTitulo(String titulo);
    Optional<LivroModel> findByIsbn(String isbn);
}
