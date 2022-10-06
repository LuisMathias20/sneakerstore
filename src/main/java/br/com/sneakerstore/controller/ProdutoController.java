package br.com.sneakerstore.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.sneakerstore.dto.ProdutoDto;
import br.com.sneakerstore.model.Marca;
import br.com.sneakerstore.model.Produto;
import br.com.sneakerstore.repository.MarcaRepository;
import br.com.sneakerstore.repository.ProdutoRepository;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	public <T> ResponseEntity<?> salvarProduto(ProdutoDto produtoDto) {
		Produto produto = new Produto();
		Optional<Marca> marca = marcaRepository.findById(produtoDto.getMarca().getId());
		
		if(!marca.isPresent()) {
			return new ResponseEntity<>("Marca não registrada na base de dados", HttpStatus.BAD_REQUEST);
		}
		
		produto = produto.converterDoDto(produtoDto);
		produto.setMarca(marca.get());
		
		return new ResponseEntity<>(produtoRepository.save(produto), HttpStatus.OK);
	}
	
	public <T>  ResponseEntity<?> consultarProduto(Integer id) {
		return new ResponseEntity<>(produtoRepository.findByIdWithMarcaAndAvaliacao(id), HttpStatus.OK);
	}
	
	public <T> ResponseEntity<?> atualizarProduto(ProdutoDto produtoDto) {
		Produto produto = new Produto();
		Optional<Marca> marca = marcaRepository.findById(produtoDto.getMarca().getId());
		
		if(!marca.isPresent()) {
			return new ResponseEntity<>("Marca não registrada na base de dados", HttpStatus.BAD_REQUEST);
		}
		
		produto = produto.converterDoDto(produtoDto);
		produto.setMarca(marca.get());
		
		return new ResponseEntity<>(produtoRepository.save(produto), HttpStatus.OK);
	}

	public <T> ResponseEntity<?> deleteProduto(Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		
		if(produto.isPresent()) {
			produtoRepository.delete(produto.get());
			return new ResponseEntity<>("Produto deleteado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Produto não encontrado", HttpStatus.NOT_MODIFIED);
		}
	}
}
