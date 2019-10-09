package br.edu.unoesc.crud.controller;

import br.edu.unoesc.crud.model.Aluguel;
import br.edu.unoesc.crud.model.Categoria;
import br.edu.unoesc.crud.service.AluguelService;
import br.edu.unoesc.crud.service.CategoriaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/rents")
@Controller
public class AluguelController extends BasicController<Aluguel> {

    @Getter
    @Autowired
    private AluguelService service;

    @PostMapping("/salvar")
    public String emprestar(Aluguel aluguel) {
        service.emprestar(aluguel);
        return "redirect:/rents/";
    }

    @GetMapping("/devolver/{codigo}")
    public String devolver(@PathVariable Long codigo, Model model) {
        if(service.devolver(codigo)){
            return Success("O empréstimo foi finalizado com sucesso", model);
        }else{
            return Error("Ops, ocorreu um erro ao finalizar o empréstimo, tente novamente mais tarde", model);
        }
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
