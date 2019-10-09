package br.edu.unoesc.crud.model;

import br.edu.unoesc.crud.model.util.EntidadePersistente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria implements EntidadePersistente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    private String nome;

    @Override
    public String toString() {
        return nome;
    }
}
