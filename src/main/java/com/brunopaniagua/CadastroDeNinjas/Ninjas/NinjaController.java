package com.brunopaniagua.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é a minha primeira mensagem nessa rota";
    }

    //Adicionar Ninja
    @PostMapping("/criar")
    public String criarNinja() {
        return "ninja criada com sucesso";
    }

    //Mostrar todos os ninjas
    @GetMapping("/todos")
    public String todos() {
        return "todos com sucesso";
    }

    //Mostrar ninja por id
    @GetMapping("/todosID")
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
