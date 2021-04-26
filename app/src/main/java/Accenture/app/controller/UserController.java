package Accenture.app.controller;

import Accenture.app.entities.Usuario;
import Accenture.app.repository.UsuarioRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired //Injeta todas as funções de conexão com o BD na propriedade userRepository.
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listAll() {
        return this.usuarioRepository.findAll();
    }

    @GetMapping(path = "/buscar")
    public ResponseEntity<List<Usuario>> findBynomeorEmail(@RequestParam (value="nome",defaultValue = "")String nome,
                                           @RequestParam (value="email", defaultValue = "")String email) {
        List<Usuario>user=usuarioRepository.findByNomeOrEmailLike(nome, email);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();


        } else {
            return ResponseEntity.ok().body(user);

        }

    }

    @GetMapping(path = "/{id}")
    public Optional<Usuario> listOne(@PathVariable Long id) {
        return this.usuarioRepository.findById(id);
    }

    @PostMapping
    public Usuario create (@RequestBody Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    @PutMapping(path = "/{id}")
    public Usuario update (@RequestBody Usuario usuario, @PathVariable Long id) {
        usuario.setId(id);
        this.usuarioRepository.save(usuario);
        return usuario;
    }

    @DeleteMapping(path = "/{id}")
    public void delete (@PathVariable Long id) {
        this.usuarioRepository.deleteById(id);
    }

}
