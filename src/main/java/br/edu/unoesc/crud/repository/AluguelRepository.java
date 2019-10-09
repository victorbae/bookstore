package br.edu.unoesc.crud.repository;

import br.edu.unoesc.crud.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

    @Query("select alu from Aluguel alu where alu.emAberto = 1")
    List<Aluguel> findAbertos();
}
