package com.example;

import java.util.function.BooleanSupplier;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean emprestado;
    private Bibliotecario bibliotecarioResponsavel;

    public Livro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.emprestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean podeSerEmprestado() {
        return !this.emprestado;
    }

    public void emprestar() {
        this.emprestado = true;
    }

    public void devolver() {
        this.emprestado = false;
    }

    public Bibliotecario getBibliotecarioResponsavel() {
        return bibliotecarioResponsavel;
    }

    public void setBibliotecarioResponsavel(Bibliotecario bibliotecarioResponsavel) {
        this.bibliotecarioResponsavel = bibliotecarioResponsavel;
    }

    public void setDisponivel(boolean b) {
       boolean disponivel = b;
    }
    
}
