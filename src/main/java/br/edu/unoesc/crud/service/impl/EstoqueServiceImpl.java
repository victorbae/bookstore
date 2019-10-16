package br.edu.unoesc.crud.service.impl;

import br.edu.unoesc.crud.model.Livro;
import br.edu.unoesc.crud.model.LivroDTO;
import br.edu.unoesc.crud.service.EstoqueService;
import br.edu.unoesc.crud.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    @Autowired
    private LivroService livroService;

    @Override
    public Integer getQntLivrosCadastrados() {
        int d= 0;
        for (Livro livro : livroService.listar()) {
            d += livro.getQtdOriginal();
        }
        return d;
    }

    @Override
    public Integer getQntLivrosAlugados() {
        int i= 0;
        for (Livro livro : livroService.listar()) {
            i += livro.getEmprestados();
        }
        return i;
    }

    @Override
    public Integer getQntLivrosDisponiveis() {
        int d= 0;
        for (Livro livro : livroService.listar()) {
            d += livro.getDisponivel();
        }
        return d;
    }

    @Override
    public LivroDTO getLivroDto() {
        return new LivroDTO(getQntLivrosCadastrados(), getQntLivrosAlugados(),getQntLivrosDisponiveis());
    }
}
