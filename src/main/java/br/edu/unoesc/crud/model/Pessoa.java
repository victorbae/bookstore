package br.edu.unoesc.crud.model;

import br.edu.unoesc.crud.model.util.EntidadePersistente;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Pessoa implements EntidadePersistente {

	private static final long serialVersionUID = 1L;

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
