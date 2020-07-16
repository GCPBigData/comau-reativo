package br.comau.repository;

import br.comau.model.ClienteFisica;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteFisicaRepository extends ReactiveMongoRepository<ClienteFisica, String> {

   ClienteFisica findByNome(String nome);

}
