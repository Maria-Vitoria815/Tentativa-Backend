package br.edu.ifba.demo.backend.api.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "genero")
public class GeneroModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero")
    private Long id_genero;


    @Column(name = "nome_genero", nullable = false)
    private String nome;


    @Column(name = "status")
    private boolean status;


    public GeneroModel() {
        super();
    }    


    public GeneroModel(String nome){
        super();
        this.nome = nome;
    }


    public GeneroModel(String nome, boolean status){
        super();
        this.nome = nome;
        this.status = status;
    } 
   
}