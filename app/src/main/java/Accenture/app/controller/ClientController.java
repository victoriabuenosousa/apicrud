package Accenture.app.controller;

import Accenture.app.entities.Cliente;
import Accenture.app.entities.Usuario;
import Accenture.app.repository.ClientRepository;
import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Cliente> listAll() {
        return this.clientRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Cliente> listOne(@PathVariable Long id) {
        return this.clientRepository.findById(id);
    }

    @GetMapping(path = "/buscar")
    public ResponseEntity<List<Cliente>> findByNomeOrCpfCnpjOrCidadeOrUf(@RequestParam (value="nome",defaultValue = "")String nome,
                                                                         @RequestParam (value="cpfnCnpj", defaultValue = "")String cpfCnpj,
    @RequestParam (value="cidade", defaultValue = "")String cidade,
    @RequestParam (value="uf", defaultValue = "")String uf) {

        List<Cliente>user=clientRepository.findByNomeOrCpfCnpjOrCidadeOrUfLike(nome, cpfCnpj, cidade, uf);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();


        } else {
            return ResponseEntity.ok().body(user);

        }

    }

    @PostMapping
    public Cliente create (@RequestBody Cliente cliente) {
        return this.clientRepository.save(cliente);
    }

    @PutMapping(path = "/{id}")
    public Cliente update (@RequestBody Cliente cliente, @PathVariable Long id) {
        cliente.setId(id);
        this.clientRepository.save(cliente);
        return cliente;
    }

    @DeleteMapping(path = "/{id}")
    public void delete (@PathVariable Long id) {
        this.clientRepository.deleteById(id);
    }
}
