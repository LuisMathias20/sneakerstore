package br.com.sneakerstore.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sneakerstore.controller.ProdutoController;
import br.com.sneakerstore.dto.ProdutoDto;

@RestController
@RequestMapping("/produto")
public class ProdutoEndpoint {
	
	@Autowired
	private ProdutoController produtoController;
	
	@PostMapping("/salvar")
	public <T> ResponseEntity<?> salvarProduto(@Valid @RequestBody ProdutoDto produtoDto) {
		return produtoController.salvarProduto(produtoDto);
	}
	
	@GetMapping("/consultar/{id}")
	public <T>  ResponseEntity<?> consultarProduto(@PathVariable("id") Integer id) {
		return produtoController.consultarProduto(id);
	}
	
	@PutMapping("/atualizar") 
	public <T> ResponseEntity<?> atualizarProduto(@Valid @RequestBody ProdutoDto produtoDto) {
		return produtoController.atualizarProduto(produtoDto);
	}
	
	@DeleteMapping("/deletar/{id}")
	public <T> ResponseEntity<?> deleteProduto(@PathVariable("id") Integer id) {
		return produtoController.deleteProduto(id);
	}
	
}
