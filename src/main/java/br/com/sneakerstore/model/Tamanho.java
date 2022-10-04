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

@Entity
@Table(name="tab_tamanho")
public class Tamanho {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="tam_id")
	private Integer id;
	
	@Column(name="tam_tamanho")
	private String tamanho;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tamanho")
	private List<ProdutoTamanho> produtoTamanho;
}
