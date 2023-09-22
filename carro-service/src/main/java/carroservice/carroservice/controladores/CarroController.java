package carroservice.carroservice.controladores;

import carroservice.carroservice.entidades.Carro;
import carroservice.carroservice.servicio.CarroService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
@AllArgsConstructor
public class CarroController {
    private final CarroService carroService;

    @GetMapping
    public ResponseEntity<List<Carro>>listarCarros(){
        List<Carro>carros = carroService.getAll();
        if (carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Carro>obtenerCarro(@PathVariable("id")int id){
        Carro carro = carroService.getCarroById(id);
        if (carro==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carro);
    }

    @PostMapping
    public ResponseEntity<Carro>guardarCarro(@RequestBody Carro carro){
        Carro nuevoCarro = carroService.save(carro);
        return ResponseEntity.ok(nuevoCarro);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Carro>>listarCarrosPorUsuarioId(@PathVariable("usuarioId")int id){
        List<Carro>carros = carroService.byUsuarioId(id);
        if (carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }

}
