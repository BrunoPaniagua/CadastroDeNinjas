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

    //Mostrar ninja por id
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id) {
        return ninjaService.listarNinjasPorId(id);
    }

    //Adicionar Ninja
    @PostMapping("/criar")
    public String criarNinja() {
        return "ninja criada com sucesso";
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
