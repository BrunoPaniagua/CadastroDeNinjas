package com.brunopaniagua.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @GetMapping("/listar")
    public List<MissaoDTO> listarMissao() {
        return missaoService.listarMissao();
    }

    @GetMapping("/listar/{id}")
    public MissaoDTO listarMissaoPorId(@PathVariable Long id) {
        return missaoService.listarMissaoPorId(id);
    }

    @PostMapping("/criar")
    public MissaoModel criarMissao(@RequestBody MissaoModel missao) {
        return missaoService.criarMissao(missao);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long id) {
        missaoService.deletarMissaoPorId(id);
    }

    @PutMapping("/alterar/{id}")
    public MissaoDTO alterarMissao(@PathVariable Long id, @RequestBody MissaoDTO missao) {
        return missaoService.atualizarMissao(id, missao);
    }

}
