package br.comau.controller;

import br.comau.model.ClienteFisica;
import br.comau.repository.ClienteFisicaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/clientefisica")
public class ClienteFisicaController {

    private final ClienteFisicaRepository clienteFisicaRepository;

    public ClienteFisicaController(ClienteFisicaRepository clienteFisicaRepository) {
        this.clienteFisicaRepository = clienteFisicaRepository;
    }

    @GetMapping("/todos")
    public Flux<ClienteFisica> getAll() {
        return clienteFisicaRepository.findAll();
    }

    @GetMapping("/busca/{id}")
    public Mono<ResponseEntity<ClienteFisica>> getById(@PathVariable String id) {
        return clienteFisicaRepository.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ClienteFisica> create(@RequestBody ClienteFisica clienteFisica) {
        return clienteFisicaRepository.save(clienteFisica);
    }

    @PutMapping("/put/{id}")
    public Mono<ResponseEntity<ClienteFisica>> update(@PathVariable String id,
                                                @RequestBody ClienteFisica clienteFisica) {
        return clienteFisicaRepository.findById(id)
                .flatMap(existingClienteFisica -> {
                    existingClienteFisica.setNome(clienteFisica.getNome());
                    return clienteFisicaRepository.save(existingClienteFisica);
                })
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable(value = "id") String id) {
        return clienteFisicaRepository.findById(id)
                .flatMap(existingClienteFisica ->
                        clienteFisicaRepository.delete(existingClienteFisica)
                                .then(Mono.just(ResponseEntity.ok().<Void>build()))
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
