package br.edu.unoesc.crud.controller;

import br.edu.unoesc.crud.model.Categoria;
import br.edu.unoesc.crud.model.Livro;
import br.edu.unoesc.crud.repository.LivroRepository;
import br.edu.unoesc.crud.service.LivroService;
import br.edu.unoesc.crud.service.util.BasicCrud;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;

@RequestMapping("/books")
@Controller
public class LivroController extends BasicController<Livro> {

    @Getter
    @Autowired
    private LivroService service;

    @PostMapping("/salvar")
    public String salvar(Livro livro) {
        service.salvar(livro);
        return "redirect:/books/";
    }

    @GetMapping("/excluir/{codigo}")
    public String excluir(@PathVariable Long codigo, Model model) {
        if (!service.isEmprestado(codigo)){
            service.excluir(codigo);
            return "redirect:/books/";
        }else{
            return toIndex("O livro não pode ser excluído pois está associado à um empréstimo", model);

        }
    }

    @Override
    protected String getListPageName() {
        return "livro/books";
    }


    @Override
    protected void imports(Model model) {
        model.addAttribute("newBook", new Livro());
    }
}
