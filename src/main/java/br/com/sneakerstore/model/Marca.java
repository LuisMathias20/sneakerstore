package br.com.sneakerstore.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.sneakerstore.dto.MarcaDto;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tab_marca")
@Getter
@Setter
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="mar_id")
	private Integer id;
	
	@Column(name="mar_nome")
	private String nome;
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "marca")
	private List<Produto> produtos;*/
	
	public Marca converterDoDto(MarcaDto marcaDto) {
		Marca marcaModel = new Marca();
		
		if(marcaDto.getId() != null) {
			marcaModel.setId(marcaDto.getId());
		}
		marcaModel.setNome(marcaDto.getNome());
		
		return marcaModel;
	}
}
