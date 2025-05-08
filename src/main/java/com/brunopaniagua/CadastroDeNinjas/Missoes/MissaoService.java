package com.brunopaniagua.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {

    private MissaoRepository missaoRepository;
    private MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    //Listar as missoes
    public List<MissaoDTO> listarMissao(){
        List<MissaoModel> missao = missaoRepository.findAll();
        return missao.stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList());
    }

    public MissaoDTO listarMissaoPorId(Long id){
        Optional<MissaoModel> missao = missaoRepository.findById(id);
        return missao.map(missaoMapper::map).orElse(null);
    }

    public MissaoModel criarMissao(MissaoModel missao){
        return missaoRepository.save(missao);
    }

    public void deletarMissaoPorId(Long id){
        missaoRepository.deleteById(id);
    }

    public MissaoDTO atualizarMissao(Long id, MissaoDTO missaoDTO){
        Optional<MissaoModel> missaoExistente = missaoRepository.findById(id);
        if(missaoExistente.isPresent()){
            MissaoModel missaoAtualizada = missaoMapper.map(missaoDTO);
            missaoAtualizada.setId(id);
            MissaoModel missaoSalva = missaoRepository.save(missaoAtualizada);
            return missaoMapper.map(missaoSalva);
        }
        return null;
    }

}
