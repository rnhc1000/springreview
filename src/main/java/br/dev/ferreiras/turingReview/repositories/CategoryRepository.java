package br.dev.ferreiras.turingReview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.ferreiras.turingReview.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
