package com.brunopaniagua.CadastroDeNinjas.Missoes;

import com.brunopaniagua.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dificuldade")
    private String dificuldade;

    // Muitos ninjas fazem parte de uma missão
    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninjas;
}
