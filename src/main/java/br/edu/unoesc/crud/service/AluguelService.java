package br.edu.unoesc.crud.service;

import br.edu.unoesc.crud.model.Aluguel;
import br.edu.unoesc.crud.service.util.BasicCrud;

import java.util.Collection;

public interface AluguelService extends BasicCrud<Aluguel> {


    void emprestar(Aluguel aluguel);

    void renovar(Long codigo);

    boolean devolver(Long codigo);

    Collection<Aluguel> listarAbertos();
}
