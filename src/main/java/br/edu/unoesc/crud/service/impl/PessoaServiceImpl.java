package br.edu.unoesc.crud.service.impl;

import br.edu.unoesc.crud.model.ClienteDTO;
import br.edu.unoesc.crud.model.Livro;
import br.edu.unoesc.crud.model.Pessoa;
import br.edu.unoesc.crud.repository.PessoaRepository;
import br.edu.unoesc.crud.service.LivroService;
import br.edu.unoesc.crud.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;

@Service
class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Override
    public void salvar(Pessoa object) {
        repository.save(object);
    }

    @Override
    public void excluir(Long objectId) {
        repository.deleteById(objectId);
    }

    @Override
    public Collection listar() {
        return (Collection) repository.findAll();
    }

    @Override
    public Pessoa findOne(Long objectId) {
        return repository.findById(objectId).get();
    }

    @Override
    public Page findPaginated(Pageable page) {
        return this.findAll(page);
    }

    @Override
    public Pessoa getEmptyList() {
        return new Pessoa(null, "Nenhum cliente encontrado !!!");
    }

    @Override
    public boolean isAlugando(Long codigo) {
        return repository.isAlugando(this.findOne(codigo));
    }

    @Override
    public Page<ClienteDTO> findAll(Pageable page) {
        return repository.findAllToDTO(LocalDate.now(), page);
    }
}
