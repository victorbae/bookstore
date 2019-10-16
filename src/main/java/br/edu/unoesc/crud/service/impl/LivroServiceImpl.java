package br.edu.unoesc.crud.service.impl;

import br.edu.unoesc.crud.model.Livro;
import br.edu.unoesc.crud.model.LivroDTO;
import br.edu.unoesc.crud.repository.LivroRepository;
import br.edu.unoesc.crud.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository repository;

    @Override
    public void salvar(Livro object) {
        if (object.getCodigo() == null) {
            object.setQuantidade(object.getQtdOriginal());
        }
        repository.save(object);
    }

    @Override
    public void excluir(Long objectId) {
            repository.deleteById(objectId);
    }

    @Override
    public boolean isEmprestado(Long objectId) {
        return repository.estaEmprestado(this.findOne(objectId));
    }

    @Override
    public Collection<Livro> listar() {
        return repository.findAll();
    }

    @Override
    public Livro findOne(Long objectId) {
        return repository.findById(objectId).get();
    }

    @Override
    public Page<Livro> findPaginated(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Livro getEmptyList() {
        return new Livro(null, "Nenhum livro encontrado !!!");
    }

    @Override
    public boolean temDisponibilidade(Livro livro) {
        return repository.findById(livro.getCodigo()).get().getQuantidade() > 0;
    }

    @Transactional
    @Override
    public void emprestar(Livro livro) {
        livro = this.findOne(livro.getCodigo());
        Integer qnt = livro.getQuantidade();
        if (qnt > 0) {
            livro.setQuantidade(qnt - 1);
            this.salvar(livro);
        }
    }

    @Transactional
    @Override
    public void devolver(Livro livro) {
        livro = this.findOne(livro.getCodigo());
        livro.setQuantidade(livro.getQuantidade() + 1);
        this.salvar(livro);
    }

}