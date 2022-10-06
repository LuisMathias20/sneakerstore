package br.com.sneakerstore.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.sneakerstore.model.Marca;

public interface MarcaRepository extends PagingAndSortingRepository<Marca, Integer> {

	
}
