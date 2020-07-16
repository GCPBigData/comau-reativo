package br.comau.repository;

import br.comau.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository 
    extends ReactiveMongoRepository<Product, String> {
}
