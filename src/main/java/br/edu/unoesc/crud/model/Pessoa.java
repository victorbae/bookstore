package br.edu.unoesc.crud.model;

import br.edu.unoesc.crud.model.util.EntidadePersistente;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString(of={"nome"})
public class Pessoa implements EntidadePersistente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    private String nome;

    private String telefone;

    public Pessoa(Long codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }

    @Override
    public String toString(){
        return nome;
    }
}
