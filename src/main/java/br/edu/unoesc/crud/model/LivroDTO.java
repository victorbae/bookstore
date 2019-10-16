package br.edu.unoesc.crud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LivroDTO {

    private Integer livrosCadastrados;

    private Integer livrosAlugados;

    private Integer livrosDisponiveis;
}
