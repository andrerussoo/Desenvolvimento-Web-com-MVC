
package com.ger.biblioteca.biblioteca.controller;

import com.ger.biblioteca.biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/livros")
public class FormularioController {

    @GetMapping("/formulario")
    public String exibirFormulario(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/formulario";
    }

    @PostMapping
    public String cadastrarLivro(@ModelAttribute("livro") Livro livro) {

        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("ISBN: " + livro.getIsbn());

        return "livros/confirmacao";
    }
}
