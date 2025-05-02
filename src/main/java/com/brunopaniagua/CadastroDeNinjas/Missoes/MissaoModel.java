package com.brunopaniagua.CadastroDeNinjas.Missoes;

import com.brunopaniagua.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String dificuldade;

    // Muitos ninjas fazem parte de uma missão
    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninjas;

    public MissaoModel() {
    }

    public MissaoModel(long id, String nome, String dificuldade, List<NinjaModel> ninjas) {
        this.id = id;
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.ninjas = ninjas;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public List<NinjaModel> getNinjas() {
        return ninjas;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public void setNinjas(List<NinjaModel> ninjas) {
        this.ninjas = ninjas;
    }
}
