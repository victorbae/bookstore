package br.edu.unoesc.crud.repository;

import br.edu.unoesc.crud.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("select CASE WHEN COUNT(alu) > 0 THEN true ELSE false END from Aluguel alu where alu.livro = ?1 and alu.emAberto = true")
    boolean estaEmprestado(Livro livro);
}
