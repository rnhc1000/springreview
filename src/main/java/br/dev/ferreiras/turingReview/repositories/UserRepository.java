package br.dev.ferreiras.turingReview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.ferreiras.turingReview.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
