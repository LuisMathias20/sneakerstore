package br.com.sneakerstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tab_produto_tamanho")
public class ProdutoTamanho {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pro_tam_id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pro_id")
	private Produto produto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tam_id")
	private Tamanho tamanho;
	
	@Column(name="pro_tam_quantidade")
	private Integer quantidade;
}
