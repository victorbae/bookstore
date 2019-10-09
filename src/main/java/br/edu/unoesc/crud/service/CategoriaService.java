package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.Categoria;
import br.edu.unoesc.crud.model.CategoriaDTO;
import br.edu.unoesc.crud.service.util.BasicCrud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoriaService extends BasicCrud<Categoria> {

    boolean temAlgumLivro(Long codigo);

    public Page<CategoriaDTO> findAll(Pageable page);
}
