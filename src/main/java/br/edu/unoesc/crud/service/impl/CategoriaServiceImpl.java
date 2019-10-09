package br.edu.unoesc.crud.service.impl;

import br.edu.unoesc.crud.model.Categoria;
import br.edu.unoesc.crud.model.CategoriaDTO;
import br.edu.unoesc.crud.repository.CategoriaRepository;
import br.edu.unoesc.crud.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Override
    public void salvar(Categoria object) {
        repository.save(object);
    }

    @Override
    public void excluir(Long objectId) {
        repository.deleteById(objectId);
    }

	@Override
    public Collection<Categoria> listar() {
        return (Collection<Categoria>) repository.findAll();
    }

    @Override
    public Categoria findOne(Long objectId) {
        return repository.findById(objectId).get();
    }

	@Override
    public Page findPaginated(Pageable page) {
        return this.findAll(page);
    }

    @Override
    public Categoria getEmptyList() {
        return new Categoria(null, "Nenhuma categoria encontrda !!!");
    }

    @Override
    public boolean temAlgumLivro(Long codigo) {
        return repository.temAlgumLivro(this.findOne(codigo));
    }

    @Override
    public Page<CategoriaDTO> findAll(Pageable page) {
        return repository.findAllToDto(page);
    }
}
