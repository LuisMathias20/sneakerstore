package br.com.sneakerstore.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.sneakerstore.model.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {

	@Query(value="SELECT p "
			+ "FROM Produto p "
			+ "JOIN FETCH p.marca m "
			+ "LEFT JOIN FETCH p.avaliacao a "
			+ "WHERE p.id = :id")
	public Produto findByIdWithMarcaAndAvaliacao(Integer id);
}
