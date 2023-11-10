package br.dev.ferreiras.turingReview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.ferreiras.turingReview.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
