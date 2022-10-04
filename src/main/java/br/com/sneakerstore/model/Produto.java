package br.com.sneakerstore.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tab_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pro_id")
	private Integer id;
	
	@Column(name="pro_nome")
	private String nome;
	
	@Column(name="pro_descricao")
	private String descricao;
	
	@Column(name="pro_preco")
	private Double preco;
	
	@Column(name="pro_identificador")
	private String identificador;
	
	@Column(name="pro_data_cadastro")
	private LocalDate dataCadastro;
	
	@Column(name="pro_data_atualizacao")
	private LocalDate dataAtualizacao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
	private List<ProdutoTamanho> produtoTamanho;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="marca_id")
	private Marca marca;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
	private List<Avaliacao> avaliacao;
	
}
