package com.moto.service.servicio;

import com.moto.service.entidades.Moto;
import com.moto.service.repositorio.MotoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MotoService {
    private final MotoRepository motoRepository;

    public List<Moto>getAll(){
        return motoRepository.findAll();
    }

    public Moto getMotoById(int id){
        return motoRepository.findById(id).orElse(null);
    }

    public Moto save(Moto moto){
        Moto nuevaMoto = motoRepository.save(moto);
        return nuevaMoto;
    }

    public List<Moto>byUsuarioId(int usuarioId){
        return motoRepository.findByUsuarioId(usuarioId);
    }
}
