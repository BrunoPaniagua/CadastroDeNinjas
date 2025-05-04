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
    public List<MissaoModel> listarMissao() {
        return missaoService.listarMissao();
    }

    @PostMapping("/criar")
    public String criarMissao() {
        return "Missao criada com sucesso!";
    }

    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missao alterada com sucesso!";
    }

    @DeleteMapping("/deletar")
    public String excluirMissao() {
        return "Missao deletada com sucesso!";
    }

}
