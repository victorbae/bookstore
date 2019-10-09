package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.ClienteDTO;
import br.edu.unoesc.crud.model.Pessoa;
import br.edu.unoesc.crud.service.util.BasicCrud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface PessoaService extends BasicCrud<Pessoa> {

    public boolean isAlugando(Long codigo);

    public Page<ClienteDTO> findAll(Pageable page);
}
