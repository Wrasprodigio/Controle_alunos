package com.durc.crud.controller;

import com.durc.crud.entidade.Estudante;
import com.durc.crud.repository.EstudanteRepositorio;
import com.durc.crud.service.EstudanteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping({"/estudantes", "/"})
    public String listarEstudantes(Model modelo) {
        modelo.addAttribute("estudantes", estudanteService.listarTodosOsEstudantes());
        return "estudantes";
    }

    @GetMapping("/estudantes/novo")
    public String mostrarFormularioDeRegistro(Model modelo ) {
        Estudante estudante = new Estudante();
        modelo.addAttribute("estudante", estudante);
        return "criar_estudante";
    }

    @RequestMapping(value = "/estudantes", method = RequestMethod.POST)
    public String novoEstudante(@Valid Estudante estudante, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/estudantes/novo";
        }
        estudanteService.novoEstudante(estudante);
        return "redirect:/estudantes";
    }

    @GetMapping("/estudantes/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("estudante", estudanteService.obterEstudantePorId(id));
        return "editar_estudante";
    }

    @PostMapping("/estudantes/{id}")
    public String atualizarEstudante(@PathVariable Long id, @ModelAttribute("estudante") Estudante estudante, Model modelo) {
        Estudante estudanteExiste = estudanteService.obterEstudantePorId(id);
        estudanteExiste.setId(id);
        estudanteExiste.setNome(estudante.getNome());
        estudanteExiste.setSobrenome(estudante.getSobrenome());
        estudanteExiste.setEmail(estudante.getEmail());

        estudanteService.atualizarEstudante(estudanteExiste);
        return "redirect:/estudantes";
    }

    @GetMapping("/estudantes/{id}")
    public String excluirEstudante(@PathVariable Long id) {
        estudanteService.excluirEstudante(id);
        return "redirect:/estudantes";
    }

}
