package Accenture.app.repository;

import java.util.List;
import java.util.Optional;

import Accenture.app.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login);
    List<Usuario>findByNomeOrEmailLike(String nome, String email);

}
