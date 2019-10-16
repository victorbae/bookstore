package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.LivroDTO;

public interface EstoqueService {

    Integer getQntLivrosCadastrados();

    Integer getQntLivrosAlugados();

    Integer getQntLivrosDisponiveis();

    LivroDTO getLivroDto();
}
