package com.brunopaniagua.CadastroDeNinjas.Missoes;

import com.brunopaniagua.CadastroDeNinjas.Ninjas.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    private final NinjaService ninjaService;
    MissaoService missaoService;

    public MissaoController(MissaoService missaoService, NinjaService ninjaService) {
        this.missaoService = missaoService;
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarMissao() {
        List<MissaoDTO> missoes = missaoService.listarMissao();

        if (missoes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).
                    body("Nenhuma missao Cadastrada");
        }
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissaoPorId(@PathVariable Long id) {

        MissaoDTO missao = missaoService.listarMissaoPorId(id);

        if (missao != null) {
            return ResponseEntity.ok(missao);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missão com id " + id + " não foi encontrada");
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissaoDTO missao) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão com id " + missao.getId() + " foi criada com sucesso");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarMissaoPorId(@PathVariable Long id) {

        if(missaoService.listarMissaoPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Missão deletada com id " + id + " foi removida com sucesso");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missão com id " + id + " não foi encontrada");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissaoDTO missao) {

        if(missaoService.listarMissaoPorId(id) != null) {
            missaoService.atualizarMissao(id, missao);
            ResponseEntity.ok(missao);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missao com id " + id + " não foi encontrada");
    }

}
