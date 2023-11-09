package br.dev.ferreiras.turingReview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.ferreiras.turingReview.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
