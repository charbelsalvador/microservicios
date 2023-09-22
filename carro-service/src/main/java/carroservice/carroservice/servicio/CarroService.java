package carroservice.carroservice.servicio;

import carroservice.carroservice.entidades.Carro;
import carroservice.carroservice.repositorio.CarroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarroService {
    private final CarroRepository carroRepository;

    public List<Carro>getAll(){
        return carroRepository.findAll();
    }

    public Carro getCarroById(int id){
        return carroRepository.findById(id).orElse(null);
    }
    public Carro save(Carro carro){
        Carro nuevoCarro = carroRepository.save(carro);
        return nuevoCarro;
    }
    public List<Carro>byUsuarioId(int usuarioId){
        return carroRepository.findByUsuarioId(usuarioId);
    }
}
