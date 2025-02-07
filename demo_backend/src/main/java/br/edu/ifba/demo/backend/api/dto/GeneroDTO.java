package br.edu.ifba.demo.backend.api.dto;

import br.edu.ifba.demo.backend.api.model.GeneroModel;
import lombok.Data;

@Data

public class GeneroDTO {
    
    private Long id_genero;
    private String nome;
    private boolean status;


    public static GeneroDTO converter(GeneroModel generoModel) {
        GeneroDTO genero = new GeneroDTO();
        genero.setId_genero(generoModel.getId_genero());
        genero.setNome(generoModel.getNome());
        genero.setStatus(generoModel.isStatus());
        return genero;
    }

}
