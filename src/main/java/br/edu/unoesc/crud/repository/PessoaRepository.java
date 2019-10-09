package br.edu.unoesc.crud.repository;

import br.edu.unoesc.crud.model.ClienteDTO;
import br.edu.unoesc.crud.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long> {

    @Query("select CASE WHEN COUNT(alu) > 0 THEN true ELSE false END from Aluguel alu where alu.pessoa = ?1 and alu.emAberto = true")
    boolean isAlugando(Pessoa pess);

    @Query(value = "select pess.codigo as codigo, pess.nome as nome, pess.telefone as telefone," +
            "(select count(alu) from Aluguel alu where alu.pessoa = pess and alu.emAberto = true) as ativos, " +
            "(select count(alu2) from Aluguel alu2 where alu2.pessoa = pess and alu2.emAberto = true and alu2.devolucao < ?1) as atrasados," +
            "(select count(alu3) from Aluguel alu3 where alu3.pessoa = pess) as total " +
            "from Pessoa pess", countQuery = "select count(pess) from Pessoa pess")
    Page<ClienteDTO> findAllToDTO(LocalDate now, Pageable page);
}
