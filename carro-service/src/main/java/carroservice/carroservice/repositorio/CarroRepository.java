package carroservice.carroservice.repositorio;

import carroservice.carroservice.entidades.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Integer> {
    List<Carro>findByUsuarioId(int usuarioId);
}
