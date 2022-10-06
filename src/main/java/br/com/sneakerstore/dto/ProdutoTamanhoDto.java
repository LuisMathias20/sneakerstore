package br.com.sneakerstore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoTamanhoDto {

	private ProdutoDto produto;
	
	private TamanhoDto tamanho;
	
	private Integer quantidade;
}
