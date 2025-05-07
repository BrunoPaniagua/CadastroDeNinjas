package com.brunopaniagua.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar todos os ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaModel listarNinjasPorId(Long id) {
       Optional<NinjaModel> ninja = ninjaRepository.findById(id);
       return ninja.orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    public NinjaModel alterarNinja(Long id, NinjaModel ninjaAtualizado) {
        if(ninjaRepository.existsById(id)) {
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }

}
