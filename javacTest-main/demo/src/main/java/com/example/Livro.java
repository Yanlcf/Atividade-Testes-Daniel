package com.example;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean emprestado;
    private Bibliotecario bibliotecarioResponsavel;
    private List<Livro> livrosEmprestados;
    private List<String> atividades;
    private Membros membro;

    public Livro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.emprestado = false;
        this.atividades = new ArrayList<>();
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

    public void registrarDevolucao() {
        for (Livro livro : livrosEmprestados) {
            if (livro.podeSerEmprestado()) {
                livro.devolver();
            }
        }
        livrosEmprestados.clear();
    }

    public void renovarEmprestimo() {
        if (!livrosEmprestados.isEmpty()) {
            for (Livro livro : livrosEmprestados) {
                this.atividades.add("Renovação do empréstimo do livro " + livro.getTitulo());
            }
        } else {

        }
    }

    public void setMembro(Membros membro) {
        this.membro = membro;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestado = emprestado;
    }
}
