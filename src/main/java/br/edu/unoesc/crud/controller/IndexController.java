package br.edu.unoesc.crud.controller;

import br.edu.unoesc.crud.service.AluguelService;
import br.edu.unoesc.crud.service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController  implements ErrorController{

    @Autowired
    private AluguelService aluguelService;
    
    @Autowired
    private LivroService livroService;

    @GetMapping({"/home", "/", "/dashboard", "/index"})
    public String index(Model model) {
        model.addAttribute("page", aluguelService.listarAbertos());
        model.addAttribute("livrosDisponiveis", livroService.getQuantidadeLivrosDisponiveis());
        model.addAttribute("livrosCadastrados", livroService.getQuantidadeLivrosCadastrados());
        model.addAttribute("livrosAlugados", livroService.getQuantidadeLivrosAlugados());
        return "dashboard";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "erro";
	}
    
}