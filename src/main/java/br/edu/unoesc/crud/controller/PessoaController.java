package br.edu.unoesc.crud.controller;

import br.edu.unoesc.crud.model.Pessoa;
import br.edu.unoesc.crud.service.PessoaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/person")
public class PessoaController extends BasicController<Pessoa> {

    @Getter
    @Autowired
    private PessoaService service;

    @PostMapping("/salvar")
    public String salvar(Pessoa pessoa) {
        service.salvar(pessoa);
        return "redirect:/person/";
    }

    @GetMapping("/excluir/{codigo}")
    public String excluir(@PathVariable Long codigo, Model model) {
        if (!service.isAlugando(codigo)) {
            service.excluir(codigo);
            return Success("Cliente excluido com sucesso", model);
        } else {
            return Error("O cliente não pode ser excluído pois está associado à um empréstimo", model);
        }
    }



    @Override
    protected void imports(Model model) {
        model.addAttribute("newPerson", new Pessoa());
    }

    @Override
    protected String getListPageName() {
        return "pessoa/persons";
    }
}
