package com.brunopaniagua.CadastroDeNinjas.Missoes;

import com.brunopaniagua.CadastroDeNinjas.Ninjas.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    private final NinjaService ninjaService;
    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService, NinjaService ninjaService) {
        this.missaoService = missaoService;
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    @Operation(
            summary = "Lista todas as missões",
            description = "Retorna uma lista com todas as missões cadastradas no banco de dados"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missões listadas com sucesso"),
            @ApiResponse(responseCode = "204", description = "Não há missões cadastradas")
    })
    public ResponseEntity<?> listarMissao() {
        List<MissaoDTO> missoes = missaoService.listarMissao();

        if (missoes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("Nenhuma missao Cadastrada");
        }
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    @Operation(
            summary = "Busca missão por ID",
            description = "Retorna os dados de uma missão específica com base no ID informado"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    public ResponseEntity<?> listarMissaoPorId(
            @Parameter(description = "ID da missão a ser buscada") @PathVariable Long id) {

        MissaoDTO missao = missaoService.listarMissaoPorId(id);

        if (missao != null) {
            return ResponseEntity.ok(missao);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missão com id " + id + " não foi encontrada");
    }

    @PostMapping("/criar")
    @Operation(
            summary = "Cria uma nova missão",
            description = "Adiciona uma nova missão no banco de dados"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao criar a missão")
    })
    public ResponseEntity<String> criarMissao(
            @Parameter(description = "Dados da nova missão a ser criada") @RequestBody MissaoDTO missao) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão com id " + missao.getId() + " foi criada com sucesso");
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(
            summary = "Deleta missão por ID",
            description = "Remove uma missão específica do banco de dados com base no ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    public ResponseEntity<?> deletarMissaoPorId(
            @Parameter(description = "ID da missão a ser deletada") @PathVariable Long id) {

        if (missaoService.listarMissaoPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Missão deletada com id " + id + " foi removida com sucesso");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missão com id " + id + " não foi encontrada");
    }

    @PutMapping("/alterar/{id}")
    @Operation(
            summary = "Atualiza missão por ID",
            description = "Altera os dados de uma missão específica no banco de dados"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missão atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    public ResponseEntity<?> alterarMissao(
            @Parameter(description = "ID da missão a ser atualizada") @PathVariable Long id,
            @Parameter(description = "Novos dados da missão") @RequestBody MissaoDTO missao) {

        if (missaoService.listarMissaoPorId(id) != null) {
            missaoService.atualizarMissao(id, missao);
            return ResponseEntity.ok(missao);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missao com id " + id + " não foi encontrada");
    }

}
