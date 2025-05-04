package com.brunopaniagua.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    //Mostrar todos os ninjas
    @GetMapping("/listar")
    public String todos() {
        return "todos com sucesso";
    }

    //Adicionar Ninja
    @PostMapping("/criar")
    public String criarNinja() {
        return "ninja criada com sucesso";
    }

    //Mostrar ninja por id
    @GetMapping("/listarID")
    public String todosTodosOsNinjasPorId() {
        return "mostrar ninja por id";
    }

    //Alterar dados dos ninjas
    @PutMapping("/alterarId")
    public String alterarNinjaPorId() {
        return "alterar ninja com sucesso";
    }

    // Deletar Ninja
    @DeleteMapping("/deletarId")
    public String deletarNinjaPorId() {
        return "deletar ninja com sucesso";
    }

}
