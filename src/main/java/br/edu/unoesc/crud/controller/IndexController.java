package br.edu.unoesc.crud.controller;

import br.edu.unoesc.crud.service.AluguelService;
import br.edu.unoesc.crud.service.EstoqueService;
import br.edu.unoesc.crud.service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private AluguelService aluguelService;
    
    @Autowired
    private EstoqueService estoqueService;

    @GetMapping({"/home", "/", "/dashboard", "/index"})
    public String index(Model model) {
        model.addAttribute("page", aluguelService.listarAbertos());
        model.addAttribute("dto", estoqueService.getLivroDto());
        return "dashboard";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }    
}