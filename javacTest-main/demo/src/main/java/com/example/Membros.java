package com.example;

import java.util.ArrayList;
import java.util.List;

public class Membros {
    private int memberId;
    private String firstName;
    private String lastName;
    private int age;
    private List<Livro> livrosEmprestados;
    private List<String> atividades;

    public Membros(int memberId, String firstName, String lastName, int age) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.livrosEmprestados = new ArrayList<>();
        this.atividades = new ArrayList<>();
    }

    // Restante do código

    public void adicionarLivroEmprestado(Livro livro) {
        this.livrosEmprestados.add(livro);
    }

    public void registrarDevolucao(Livro livro) {
        this.livrosEmprestados.remove(livro);
        livro.devolver();
    }

    public int getMemberId() {
        return this.memberId;
    }

    public void registrarEmprestimo(Livro livroMock) {
        adicionarLivroEmprestado(livroMock);
        livroMock.emprestar();
    }

    public void registrarRenovacao(Livro livro) {
        this.atualizarAtividades("Renovação do empréstimo do livro " + livro.getTitulo());
    }

    public void atualizarAtividades(String atividade) {
        this.atividades.add(atividade);
    }

    public boolean possuiLivrosEmprestados() {
        return livrosEmprestados != null && !livrosEmprestados.isEmpty();
    }
    
}
