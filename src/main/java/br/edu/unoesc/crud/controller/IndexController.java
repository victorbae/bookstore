package br.edu.unoesc.crud.controller;

import br.edu.unoesc.crud.service.AluguelService;
import br.edu.unoesc.crud.service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private AluguelService aluguelService;
    
    @Autowired
    private LivroService livroService;

    @GetMapping({"/home", "/", "/dashboard", "/index"})
    public String index(Model model) {
        model.addAttribute("page", aluguelService.listarAbertos());
        return "dashboard";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    @GetMapping(value = "/getLivrosdisponiveis")
    public @ResponseBody Integer getqtd() {
    	return livroService.getQuantidadeLivrosDisponiveis();
    
    }
    
    @GetMapping(value = "/getLivrosCadastrados")
    public @ResponseBody Integer getqtdCadastrados() {
    	return livroService.getQuantidadeLivrosCadastrados();
    
    }
    
    @GetMapping(value = "/getLivrosAlugados")
    public @ResponseBody Integer getqtdAlugados() {
    	return livroService.getQuantidadeLivrosAlugados();
    
    }
    
}