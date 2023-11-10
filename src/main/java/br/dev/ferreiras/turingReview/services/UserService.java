package br.dev.ferreiras.turingReview.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.ferreiras.turingReview.entities.User;
import br.dev.ferreiras.turingReview.repositories.UserRepository;

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
		return user.get();
	}

	public User insert(User user) {
		return repository.save(user);
	}

	public void delete(Long id) {

		repository.deleteById(id);
	}

	public User update(Long id, User user) {

		User entity = repository.getReferenceById(id);
		updateData(entity, user);
		return repository.save(entity);

	}

	private void updateData(User entity, User user) {

		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());

	}

}
