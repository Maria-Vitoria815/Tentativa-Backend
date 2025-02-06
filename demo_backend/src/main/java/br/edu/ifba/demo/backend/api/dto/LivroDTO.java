package br.edu.ifba.demo.backend.api.dto;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.demo.backend.api.model.LivroModel;


public class LivroDTO {


    private long id_livro;
    private String titulo;
    private String autor;
    private String editora;
    private Integer ano_publicacao;
    private String genero;
    private String isbn;
    private Integer num_paginas;
    private String sinopse;
    private String idioma;
    private LocalDateTime data_cadastro;
    private double preco;


    public static LivroDTO converter(LivroModel livroModel){


        var livro = new LivroDTO();
        livro.setId_livro(livroModel.getId_livro());
        livro.setTitulo(livroModel.getTitulo());
        livro.setAutor(livroModel.getAutor());
        livro.setEditora(livroModel.getEditora());
        livro.setAno_publicacao(livroModel.getAno_publicacao());
        livro.setGenero(livroModel.getGenero());
        livro.setIsbn(livroModel.getIsbn());
        livro.setNum_paginas(livroModel.getNum_paginas());
        livro.setSinopse(livroModel.getSinopse());
        livro.setIdioma(livroModel.getIdioma());
        livro.setData_cadastro(livroModel.getData_cadastro());
        livro.setPreco(livroModel.getPreco());
        return livro;

    }


    public static List<LivroDTO> converter(List<LivroModel> livro){
        List<LivroDTO> list = new ArrayList<>();
        for (LivroModel model : livro){

            list.add(LivroDTO.converter(model));

        }

        return list;

    }

    public LivroDTO(){

        super();

    }

    public LivroDTO
    (long id_livro, String titulo, String autor, String editora, Integer ano_publicacao, 
    String genero, String isbn, Integer num_paginas, String sinopse, String idioma,
    LocalDateTime data_cadastro, double preco){

        super();
        this.id_livro = id_livro;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano_publicacao = ano_publicacao;
        this.genero = genero;
        this.isbn = isbn;
        this.num_paginas = num_paginas;
        this.sinopse = sinopse;
        this.idioma = idioma;
        this.data_cadastro = data_cadastro;
        this.preco = preco;

    }


    public long getId_livro() {
        return id_livro;
    }


    public void setId_livro(long id_livro) {
        this.id_livro = id_livro;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getAutor() {
        return autor;
    }


    public void setAutor(String autor) {
        this.autor = autor;
    }


    public String getEditora() {
        return editora;
    }


    public void setEditora(String editora) {
        this.editora = editora;
    }


    public Integer getAno_publicacao() {
        return ano_publicacao;
    }


    public void setAno_publicacao(Integer ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }


    public String getGenero() {
        return genero;
    }


    public void setGenero(String genero) {
        this.genero = genero;
    }


    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public Integer getNum_paginas() {
        return num_paginas;
    }


    public void setNum_paginas(Integer num_paginas) {
        this.num_paginas = num_paginas;
    }


    public String getSinopse() {
        return sinopse;
    }


    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }


    public String getIdioma() {
        return idioma;
    }


    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }


    public LocalDateTime getData_cadastro() {
        return data_cadastro;
    }


    public void setData_cadastro(LocalDateTime data_cadastro) {
        this.data_cadastro = data_cadastro;
    }


    public double getPreco() {
        return preco;
    }


    public void setPreco(double preco) {
        this.preco = preco;
    }

}
