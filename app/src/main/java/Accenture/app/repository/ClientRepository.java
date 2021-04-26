package Accenture.app.repository;

import Accenture.app.entities.Cliente;
import Accenture.app.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeOrCpfCnpjOrCidadeOrUfLike(String nome, String cpfCnpj, String cidade, String uf);

}
