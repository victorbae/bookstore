package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.Livro;
import br.edu.unoesc.crud.service.util.BasicCrud;

public interface LivroService extends BasicCrud<Livro> {

    boolean temDisponibilidade(Livro livro);

    void emprestar(Livro livro) ;

    void devolver(Livro livro);

    public boolean isEmprestado(Long objectId);
    
    public Integer getQuantidadeLivrosCadastrados();
    
    public Integer getQuantidadeLivrosAlugados();
    
    public Integer getQuantidadeLivrosDisponiveis();
}
