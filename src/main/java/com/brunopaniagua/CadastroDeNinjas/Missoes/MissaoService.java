package com.brunopaniagua.CadastroDeNinjas.Missoes;

import com.brunopaniagua.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

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

    public MissaoModel listarMissaoPorId(Long id){
        Optional<MissaoModel> missao = missaoRepository.findById(id);
        return missao.orElse(null);
    }

    public MissaoModel criarMissao(MissaoModel missao){
        return missaoRepository.save(missao);
    }

    public void deletarMissaoPorId(Long id){
        missaoRepository.deleteById(id);
    }

}
