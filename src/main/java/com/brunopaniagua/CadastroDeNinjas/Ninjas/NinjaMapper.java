package com.brunopaniagua.CadastroDeNinjas.Ninjas;

import com.brunopaniagua.CadastroDeNinjas.Missoes.MissaoMapper;
import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    private final MissaoMapper missaoMapper;

    public NinjaMapper(MissaoMapper missaoMapper) {
        this.missaoMapper = missaoMapper;
    }

    public NinjaModel map(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setImgUrl(ninjaDTO.getImgUrl());
        ninjaModel.setRank(ninjaDTO.getRank());

        if (ninjaDTO.getMissao() != null) {
            ninjaModel.setMissao(missaoMapper.map(ninjaDTO.getMissao()));
        }

        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel) {
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setImgUrl(ninjaModel.getImgUrl());
        ninjaDTO.setRank(ninjaModel.getRank());

        if (ninjaModel.getMissao() != null) {
            ninjaDTO.setMissao(missaoMapper.map(ninjaModel.getMissao()));
        }

        return ninjaDTO;
    }

}
