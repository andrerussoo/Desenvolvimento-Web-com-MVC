
package com.ger.biblioteca.biblioteca.controller;

import com.ger.biblioteca.biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private List<Livro> livros = new ArrayList<>();


    @GetMapping
    public String inicio() {
        return "livros/inicio";
    }


    @GetMapping("/formulario")
    public String exibirFormulario(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/formulario";
    }


    @PostMapping
    public String cadastrar(@ModelAttribute("livro") Livro livro) {

        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("ISBN: " + livro.getIsbn());

        livros.add(livro);

        return "livros/confirmacao";
    }


    @GetMapping("/lista")
    public String listar(Model model) {
        model.addAttribute("livros", livros);
        return "livros/lista";
    }


    @PostMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {

        if (indice >= 0 && indice < livros.size()) {
            livros.remove(indice);
        }

        return "redirect:/livros/lista";
    }
}
