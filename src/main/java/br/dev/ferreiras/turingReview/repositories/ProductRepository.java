package br.dev.ferreiras.turingReview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.ferreiras.turingReview.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
