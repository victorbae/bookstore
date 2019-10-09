package br.edu.unoesc.crud.model;

public interface ClienteDTO {

    long getCodigo();
    String getNome();
    String getTelefone();
    long getAtivos();
    long getAtrasados();
    long getTotal();

}
