package br.edu.unoesc.crud.service.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface BasicCrud<T> {

    void salvar(T object);

    void excluir(Long objectId);

    Collection<T> listar();

    T findOne(Long objectId);

    Page<T> findPaginated(Pageable page);

    T getEmptyList();

}
