package br.edu.unoesc.crud.controller;

import br.edu.unoesc.crud.model.Categoria;
import br.edu.unoesc.crud.model.Livro;
import br.edu.unoesc.crud.service.CategoriaService;
import br.edu.unoesc.crud.service.LivroService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;

@RequestMapping("/booktypes")
@Controller
public class CategoriaController extends BasicController<Categoria> {

    @Getter
    @Autowired
    private CategoriaService service;

    @PostMapping("/salvar")
    public String salvar(Categoria categoria) {
        service.salvar(categoria);
        return "redirect:/booktypes/";
    }

    @GetMapping("/excluir/{codigo}")
    public String excluir(@PathVariable Long codigo, Model model) {
        if (!service.temAlgumLivro(codigo)){
            service.excluir(codigo);
            return "redirect:/booktypes/";
        }else{
           return toIndex("Esta categoria não pode ser excluida pos existem livros associados à ela", model);
        }

    }

    @Override
    protected String getListPageName() {
        return "categoria/booktypes";
    }

    @Override
    protected void imports(Model model) {
        model.addAttribute("newBookType", new Categoria());
    }
}
