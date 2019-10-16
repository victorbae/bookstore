package br.edu.unoesc.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LivroDTO {

    private Integer quantidadeLivrosCadastrados;

    private Integer quantidadeLivrosAlugados;

    private Integer quantidadeLivrosDisponiveis;
}
