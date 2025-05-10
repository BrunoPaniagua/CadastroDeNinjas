package com.brunopaniagua.CadastroDeNinjas.Ninjas;

import com.brunopaniagua.CadastroDeNinjas.Missoes.MissaoDTO;
import com.brunopaniagua.CadastroDeNinjas.Missoes.MissaoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private int idade;
    private String imgUrl;
    private String rank;
    private MissaoDTO missao;

}
