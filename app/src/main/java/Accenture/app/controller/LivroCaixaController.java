package Accenture.app.controller;

import Accenture.app.entities.Cliente;
import Accenture.app.entities.LivroCaixa;
import Accenture.app.entities.Usuario;
import Accenture.app.repository.LivroCaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/livrocaixa")
public class LivroCaixaController {

    @Autowired
    private LivroCaixaRepository livroCaixaRepository;

    @GetMapping
    public List<LivroCaixa> listAll() {
        return this.livroCaixaRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<LivroCaixa> listOne(@PathVariable Long id) {
        return this.livroCaixaRepository.findById(id);
    }

    @GetMapping(path = "/buscar/cliente")
    public ResponseEntity<List<LivroCaixa>> findByClienteId(@RequestParam(value="cliente",defaultValue = "")Long cliente) {

        List<LivroCaixa> clienteId=livroCaixaRepository.findByClienteId(cliente);
        if (clienteId.isEmpty()) {
            return ResponseEntity.notFound().build();


        } else {
            return ResponseEntity.ok().body(clienteId);

        }

    }

    @PostMapping
    public LivroCaixa create (@RequestBody LivroCaixa livrocaixa) {
        return this.livroCaixaRepository.save(livrocaixa);
    }

    @PutMapping(path = "/{id}")
    public LivroCaixa update (@RequestBody LivroCaixa livroCaixa, @PathVariable Long id) {
        livroCaixa.setId(id);
        this.livroCaixaRepository.save(livroCaixa);
        return livroCaixa;
    }

    @DeleteMapping(path = "/{id}")
    public void delete (@PathVariable Long id) {
        this.livroCaixaRepository.deleteById(id);
    }
}
