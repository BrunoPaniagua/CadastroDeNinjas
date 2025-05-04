package com.brunopaniagua.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //Mostrar todos os ninjas
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
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
