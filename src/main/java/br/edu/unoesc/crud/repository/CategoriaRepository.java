package br.edu.unoesc.crud.repository;

import br.edu.unoesc.crud.model.Categoria;
import br.edu.unoesc.crud.model.CategoriaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Long> {

    @Query("select CASE WHEN COUNT(li) > 0 THEN true ELSE false END from Livro li where li.categoria = ?1")
    boolean temAlgumLivro(Categoria one);

    @Query(value = "select cat.codigo as codigo, cat.nome as nome, (select count(li) from Livro li where li.categoria = cat) as total from Categoria cat",
            countQuery = "select count(cat) from Categoria cat")
    Page<CategoriaDTO> findAllToDto(Pageable page);
}
