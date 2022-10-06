package br.com.sneakerstore.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sneakerstore.dto.MarcaDto;
import br.com.sneakerstore.model.Marca;
import br.com.sneakerstore.repository.MarcaRepository;

@RestController
@RequestMapping("marca")
public class MarcaEndpoint {

	@Autowired
	private MarcaRepository marcaRepository;
	
	@PostMapping("salvar")
	public <T> ResponseEntity<?> salvarMarca(@RequestBody MarcaDto marcaDto) {
		Marca marca = new Marca();
		
		return new ResponseEntity<>(marcaRepository.save(marca.converterDoDto(marcaDto)), HttpStatus.OK);
	}
}
