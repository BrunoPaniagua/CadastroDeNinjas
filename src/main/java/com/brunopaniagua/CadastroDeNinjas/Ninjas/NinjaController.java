package com.brunopaniagua.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaRepository ninjaRepository;
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService, NinjaRepository ninjaRepository) {
        this.ninjaService = ninjaService;
        this.ninjaRepository = ninjaRepository;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();

        if (ninjas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).
                    body("Nenhuma ninja cadastrado");
        }
        return ResponseEntity.ok(ninjas);
    }

    //Mostrar ninja por id
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {

        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);

        if(ninja != null) {
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com "+id+" nao encontrada");

    }

    //Adicionar Ninja
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja " + novoNinja.getNome() + " criado com sucesso!");
    }

    // Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {

        if(ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja " + id + " deletado com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O ninja com o id " + id + " não foi encontrado!");
    }

    //Alterar dados dos ninjas
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {

        if(ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.alterarNinja(id, ninjaAtualizado);
            return ResponseEntity.ok(ninjaAtualizado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o id " + id + " não foi encontrado!");

    }

}
