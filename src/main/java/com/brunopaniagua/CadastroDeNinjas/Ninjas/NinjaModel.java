package com.brunopaniagua.CadastroDeNinjas.Ninjas;

import com.brunopaniagua.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_ninja")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    //Um ninja pode ter apenas UMA missão
    @ManyToOne
    @JoinColumn(name = "missao_id") // Chave estrangeira
    private MissaoModel missao;

}
