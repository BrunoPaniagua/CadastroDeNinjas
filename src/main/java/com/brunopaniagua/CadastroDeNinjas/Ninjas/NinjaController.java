package com.brunopaniagua.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(
            summary = "Lista todos os ninjas",
            description = "Lista todos os ninjas salvos no banco de dados"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninjas listados com sucesso"),
            @ApiResponse(responseCode = "204", description = "Não há ninjas cadastrados no banco de dados")
    })
    public ResponseEntity<?> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();

        if (ninjas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("Nenhuma ninja cadastrado");
        }
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    @Operation(
            summary = "Lista ninja por ID",
            description = "Retorna um ninja específico com base no ID informado"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não foi encontrado")
    })
    public ResponseEntity<?> listarNinjasPorId(
            @Parameter(description = "ID do ninja a ser consultado") @PathVariable Long id
    ) {
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);

        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com " + id + " nao encontrada");
    }

    @PostMapping("/criar")
    @Operation(
            summary = "Cria um novo ninja",
            description = "Cria e salva um novo ninja no banco de dados"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja " + novoNinja.getNome() + " criado com sucesso!");
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(
            summary = "Deleta ninja por ID",
            description = "Remove um ninja do banco de dados com base no ID informado"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não foi encontrado")
    })
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja " + id + " deletado com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O ninja com o id " + id + " não foi encontrado!");
    }

    @PutMapping("/alterar/{id}")
    @Operation(
            summary = "Altera um ninja existente",
            description = "Atualiza os dados de um ninja no banco de dados com base no ID informado"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não foi encontrado")
    })
    public ResponseEntity<?> alterarNinjaPorId(
            @Parameter(description = "ID do ninja a ser alterado") @PathVariable Long id,
            @Parameter(description = "Dados atualizados do ninja") @RequestBody NinjaDTO ninjaAtualizado
    ) {
        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.alterarNinja(id, ninjaAtualizado);
            return ResponseEntity.ok(ninjaAtualizado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o id " + id + " não foi encontrado!");
    }


}
