package Accenture.app.repository;

import java.util.List;

import Accenture.app.entities.LivroCaixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroCaixaRepository extends JpaRepository<LivroCaixa, Long> {
    List<LivroCaixa> findByClienteId(Long idcliente);

}
