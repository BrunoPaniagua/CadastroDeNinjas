package com.brunopaniagua.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    @GetMapping("/listar")
    public String listarMissao() {
        return "Lista de missoes";
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
