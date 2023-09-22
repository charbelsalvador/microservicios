package com.usuario.service.controlador;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import com.usuario.service.servicio.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>>listarUsuario(){
        List<Usuario>usuarios=usuarioService.getAll();
        if (usuarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario>obtenerUsuario(@PathVariable("id")int id){
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario>guardarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioNuevo = usuarioService.save(usuario);
        return ResponseEntity.ok(usuarioNuevo);
    }

    @GetMapping("/carros/{usuarioId}")
    public ResponseEntity<List<Carro>>listarCarros(@PathVariable("usuarioId") int id){
        Usuario usuario=usuarioService.getUsuarioById(id);
        if (usuario==null){
            return ResponseEntity.notFound().build();
        }
        List<Carro>carros = usuarioService.getCarros(id);
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/motos/{usuarioId}")
    public ResponseEntity<List<Moto>>listarMotos(@PathVariable("usuarioId")int id){
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario==null){
            return ResponseEntity.notFound().build();
        }
        List<Moto>motos = usuarioService.getMotos(id);
        return ResponseEntity.ok(motos);
    }
}
