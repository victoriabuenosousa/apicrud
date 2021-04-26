package Accenture.app.controller;

import Accenture.app.entities.Auth;
import Accenture.app.entities.Usuario;
import Accenture.app.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<String> logar (@RequestBody Auth object){
        Optional<Usuario> login = usuarioRepository.findByLogin(object.getLogin());
        if (login.isPresent()) {
            Usuario usuario = login.get();
            if (!usuario.getSenha().equals(object.getSenha())) {
                return ResponseEntity.ok("Senha incorreta!");

            }

            if (usuario.getStatus().equals("C")) {
                return ResponseEntity.ok("Usuário cancelado!");
            }

            return ResponseEntity.ok("Logado com sucesso!");
        }

        else {
            return ResponseEntity.ok("Usuário não encontrado!");
        }
    }

}