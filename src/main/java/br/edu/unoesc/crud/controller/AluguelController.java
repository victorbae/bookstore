package br.edu.unoesc.crud.controller;

import br.edu.unoesc.crud.model.Aluguel;
import br.edu.unoesc.crud.service.AluguelService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@RequestMapping("/rents")
@Controller
public class AluguelController extends BasicController<Aluguel> {

    @Getter
    @Autowired
    private AluguelService service;

    @PostMapping("/salvar")
    public String emprestar(@Valid @ModelAttribute Aluguel aluguel, BindingResult result, Model model) {
        if (result.hasErrors()){
            model.addAttribute("newRent", aluguel);
            model.addAttribute("error","Ops, ocorreu um erro ao realizar o empréstimo, tente novamente mais tarde :)");
            return "aluguel/novo";
        }

        service.emprestar(aluguel);
        return "redirect:/rents/";
    }

    @GetMapping("/devolver/{codigo}")
    public String devolver(@PathVariable Long codigo, Model model) {
        if(service.devolver(codigo)){
            return success("O empréstimo foi finalizado com sucesso", model);
        }else{
            return error("Ops, ocorreu um erro ao finalizar o empréstimo, tente novamente mais tarde", model);
        }
    }
    
    @GetMapping("/novo")
    public String novo(Model model) {
    	model.addAttribute("newRent", new Aluguel());
        return "aluguel/novo";
    }

    @GetMapping("/renovar/{codigo}")
    public String renovar(@PathVariable Long codigo) {
        service.renovar(codigo);
        return "redirect:/rents/";
    }

    @Override
    protected void imports(Model model) {
        model.addAttribute("newRent", new Aluguel());
    }

    @Override
    protected String getListPageName() {
        return "aluguel/rents";
    }
}
