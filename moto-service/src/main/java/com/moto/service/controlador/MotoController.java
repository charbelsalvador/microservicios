package com.moto.service.controlador;

import com.moto.service.entidades.Moto;
import com.moto.service.servicio.MotoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
@AllArgsConstructor
public class MotoController {
    private final MotoService motoService;

    @GetMapping
    public ResponseEntity<List<Moto>>listaMoto(){
        List<Moto>motos = motoService.getAll();
        if (motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moto>obtenerMoto(@PathVariable("id")int id){
        Moto moto = motoService.getMotoById(id);
        if (moto==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(moto);
    }

    @PostMapping
    public ResponseEntity<Moto>guardarMoto(@RequestBody Moto moto){
        Moto nuevaMoto = motoService.save(moto);
        return ResponseEntity.ok(nuevaMoto);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Moto>>listarMotoPorUsuarioId(@PathVariable("usuarioId")int id){
        List<Moto>motos = motoService.byUsuarioId(id);
        if (motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }
}
