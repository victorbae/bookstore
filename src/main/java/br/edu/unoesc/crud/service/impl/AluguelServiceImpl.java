package br.edu.unoesc.crud.service.impl;

import br.edu.unoesc.crud.model.Aluguel;
import br.edu.unoesc.crud.repository.AluguelRepository;
import br.edu.unoesc.crud.service.AluguelService;
import br.edu.unoesc.crud.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collection;

@Service
class AluguelServiceImpl implements AluguelService {

    @Autowired
    private AluguelRepository repository;

    @Autowired
    private LivroService livroService;

    @Transactional
    @Override
    public void emprestar(Aluguel object) {
        if (livroService.temDisponibilidade(object.getLivro())) {
                livroService.emprestar(object.getLivro());
                this.salvar(object);
        }
    }

    @Override
    public void salvar(Aluguel object) {
        repository.save(object);
    }

    @Override
    public void excluir(Long objectId) {
        repository.deleteById(objectId);
    }

    @Override
    public Collection<Aluguel> listar() {
        return repository.findAll();
    }

    @Override
    public Aluguel findOne(Long objectId) {
        return repository.findById(objectId).get();
    }

    @Override
    public Page<Aluguel> findPaginated(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Aluguel getEmptyList() {
        return null;
    }

    @Transactional
    @Override
    public void renovar(Long codigo) {
        LocalDate pluss = LocalDate.now().plusDays(30);
        Aluguel all = this.findOne(codigo);
        all.setDevolucao(pluss);
        this.salvar(all);
    }

    @Transactional
    @Override
    public boolean devolver(Long codigo) {
        try {
            Aluguel all = this.findOne(codigo);
            livroService.devolver(all.getLivro());
            all.setEmAberto(false);
            this.salvar(all);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Collection<Aluguel> listarAbertos() {
        return repository.findAbertos();
    }
}
