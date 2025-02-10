package br.edu.ifba.demo.backend.api.model;




import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;




@Data
@Entity
@Table(name = "livro")
public class LivroModel {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livro")
    private Long id_livro;
   
    @Column(name = "titulo", nullable = false)
    private String titulo;




    @Column(name = "autor", nullable = false)
    private String autor;
   
    @Column(name = "editora", nullable = true)
    private String editora;
   
    @Column(name = "ano_publicacao", nullable = true)
    private Integer ano_publicacao;

    @ManyToOne
    @JoinColumn(name = "id_genero", nullable = true)
    private GeneroModel genero;

    @Column(name = "isbn", nullable = true)
    private String isbn;

    @Column(name = "num_paginas", nullable = true)
    private Integer num_paginas;

    @Column(name = "sinopse", nullable = true)
    private String sinopse;

    @Column(name = "idioma", nullable = true)
    private String idioma;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime data_cadastro = LocalDateTime.now();

    @Column(name = "preco", nullable = true)
    private Double preco;



    public LivroModel(){
        super();
    }


    public LivroModel(String titulo, String autor, String editora, Integer ano_publicacao, String isbn, Integer num_paginas, String sinopse, String idioma,
    LocalDateTime data_cadastro, double preco, GeneroModel genero){


        super();
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano_publicacao = ano_publicacao;
        this.isbn = isbn;
        this.num_paginas = num_paginas;
        this.sinopse = sinopse;
        this.idioma = idioma;
        this.data_cadastro = data_cadastro;
        this.preco = preco;
        this.genero = genero;
    }


}
