package br.dev.ferreiras.turingReview.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.dev.ferreiras.turingReview.entities.User;
import br.dev.ferreiras.turingReview.repositories.UserRepository;
import br.dev.ferreiras.turingReview.services.exceptions.DatabaseException;
import br.dev.ferreiras.turingReview.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

/**
 * to DI to work for a bean created must be registered at Spring Boot. In order
 * to do so make usage of annotations as @Component, @Service or @Repository....
 */

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User user) {

		return repository.save(user);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}

	}

	public User update(Long id, User user) {

		User entity = repository.getReferenceById(id);
		try {
			updateData(entity, user);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		return repository.save(entity);

	}

	private void updateData(User entity, User user) {

		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());

	}

}
