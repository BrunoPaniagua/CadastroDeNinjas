package com.brunopaniagua.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {

    private MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    //Listar as missoes
    public List<MissaoModel> listarMissao(){
        return missaoRepository.findAll();
    }
}
