
package com.ger.biblioteca.biblioteca.controller;

import com.ger.biblioteca.biblioteca.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/livros/autores")
public class AutorController {

    @GetMapping("/autorFormulario")
    public String exibirFormulario(Model model) {
        model.addAttribute("autor", new Autor());
        return "livros/autores/autorFormulario";
    }

    @PostMapping
    public String cadastrarAutor(
            @ModelAttribute("autor") Autor autor) {

        System.out.println("Nome: " + autor.getNome());
        System.out.println("Nacionalidade: " + autor.getNacionalidade());

        return "livros/autores/confirmacaoAutor";
    }
}
