package br.com.sneakerstore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {
	
	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	private Double preco;
	
	private String identificador;
	
	private MarcaDto marca;

}
