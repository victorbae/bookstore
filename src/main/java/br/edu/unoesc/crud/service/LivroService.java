package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.Livro;
import br.edu.unoesc.crud.model.LivroDTO;
import br.edu.unoesc.crud.service.util.BasicCrud;

public interface LivroService extends BasicCrud<Livro> {

    boolean temDisponibilidade(Livro livro);

    void emprestar(Livro livro);

    void devolver(Livro livro);

    boolean isEmprestado(Long objectId);
}
