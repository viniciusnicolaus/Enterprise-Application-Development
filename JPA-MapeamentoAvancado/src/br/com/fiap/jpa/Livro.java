package br.com.fiap.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_LIVRO")
public class Livro {

	@Id
	@Column(name="nr_isbn")
	private long isbn;
	
	@Column(name="ds_titulo",nullable=false)
	private String titulo;
	
	@Column(name="ds_categoria", nullable=false)
	private CategoriaLivro categoria;
	
	@Column(name="nr_pagina")
	private int numeroPaginas;

	public Livro() {
		
	}
	public Livro(long isbn, String titulo, CategoriaLivro categoria, int numeroPaginas) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.categoria = categoria;
		this.numeroPaginas = numeroPaginas;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public CategoriaLivro getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaLivro categoria) {
		this.categoria = categoria;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
}
