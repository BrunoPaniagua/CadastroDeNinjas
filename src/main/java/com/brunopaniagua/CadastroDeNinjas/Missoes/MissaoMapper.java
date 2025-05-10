package com.brunopaniagua.CadastroDeNinjas.Missoes;

import com.brunopaniagua.CadastroDeNinjas.Ninjas.NinjaDTO;
import com.brunopaniagua.CadastroDeNinjas.Ninjas.NinjaMapper;
import com.brunopaniagua.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MissaoMapper {

    private final NinjaMapper ninjaMapper;

    public MissaoMapper(NinjaMapper ninjaMapper) {
        this.ninjaMapper = ninjaMapper;
    }

    public MissaoModel map(MissaoDTO missaoDTO){
        MissaoModel missaoModel = new MissaoModel();
        missaoModel.setId(missaoDTO.getId());
        missaoModel.setNome(missaoDTO.getNome());
        missaoModel.setDificuldade(missaoDTO.getDificuldade());

        List<NinjaModel> ninjas = missaoDTO.getNinjas().stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());

        missaoModel.setNinjas(ninjas);

        return missaoModel;
    }

    public MissaoDTO map(MissaoModel missaoModel){
        MissaoDTO missaoDTO = new MissaoDTO();
        missaoDTO.setId(missaoModel.getId());
        missaoDTO.setNome(missaoModel.getNome());
        missaoDTO.setDificuldade(missaoModel.getDificuldade());

        List<NinjaDTO> ninjas = missaoModel.getNinjas().stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
        missaoDTO.setNinjas(ninjas);

        return missaoDTO;
    }
}
