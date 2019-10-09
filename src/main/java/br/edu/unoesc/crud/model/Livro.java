package br.edu.unoesc.crud.model;

import br.edu.unoesc.crud.model.util.EntidadePersistente;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@ToString(of = {"nome"})
public class Livro implements EntidadePersistente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    private String nome;

    @JoinColumn(name = "codcategoria")
    @OneToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

    private Integer quantidade;

    private Integer qtdOriginal;

    public Integer getTotal() {
        return qtdOriginal;
    }

    public Integer getDisponivel() {
        return quantidade;
    }

    public Integer getEmprestados() {
        return qtdOriginal - quantidade;
    }

    public Livro(Long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

}
