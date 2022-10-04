package br.com.sneakerstore.model;

import java.time.LocalDate;

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
@Table(name="tab_avaliacao")
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ava_id")
	private Integer id;
	
	@Column(name="ava_comentario")
	private String comentario;
	
	@Column(name="ava_nota")
	private String nota;
	
	@Column(name="ava_data_comentario")
	private LocalDate dataComentario;
	
	@Column(name="ava_likes")
	private Integer likes;
	
	@Column(name="ava_dislikes")
	private Integer dislikes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="produto_id")
	private Produto produto;

}
