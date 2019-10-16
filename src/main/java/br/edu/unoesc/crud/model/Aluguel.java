package br.edu.unoesc.crud.model;

import br.edu.unoesc.crud.model.util.EntidadePersistente;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.time.LocalDate;

@Entity
@Data
public class Aluguel implements EntidadePersistente {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @JoinColumn(name = "codlivro")
    @OneToOne(fetch = FetchType.EAGER)
    private Livro livro;

    @JoinColumn(name = "pessoa", nullable = false)
    @ManyToOne
    private Pessoa pessoa;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate emprestimo = LocalDate.now();

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future
    private LocalDate devolucao;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean emAberto = true;

    public String getSituacao() {
        return emAberto ? (!devolucao.isAfter(LocalDate.now()) ? "Atrasado" : "Em aberto") : "Fechado";
    }
}
