package br.edu.ifba.demo.backend.api.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifba.demo.backend.api.model.GeneroModel;


public interface GeneroRepository extends JpaRepository<GeneroModel, Long>{

    Optional<GeneroModel> findByNome(String nome);

}