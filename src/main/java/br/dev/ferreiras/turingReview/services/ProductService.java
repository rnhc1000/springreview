package br.dev.ferreiras.turingReview.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.ferreiras.turingReview.entities.Product;
import br.dev.ferreiras.turingReview.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {

		return productRepository.findAll();

	}

	public Product findById(Long id) {

		Optional<Product> product = productRepository.findById(id);
		return product.get();

	}

}
