package com.usuario.service.servicio;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import com.usuario.service.repositorio.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {
    private final RestTemplate restTemplate;
    private final UsuarioRepository usuarioRepository;

    public List<Carro>getCarros(int usuarioId){
        List<Carro>carros = restTemplate.getForObject("http://localhost:8082/carro/usuario/"+usuarioId,List.class);
        return carros;
    }

    public List<Moto>getMotos(int usuarioId){
        List<Moto>motos = restTemplate.getForObject("http://localhost:8083/moto/usuario/" + usuarioId,List.class);
        return motos;
    }

    public List<Usuario>getAll(){
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(int id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario){
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return nuevoUsuario;
    }



}
