package com.example;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> acervo;
    private List<Membros> membros;
    private List<Bibliotecario> bibliotecarios;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        acervo = new ArrayList<>();
        membros = new ArrayList<>();
        bibliotecarios = new ArrayList<>();
        emprestimos = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        acervo.add(livro);
    }

    public void cadastrarMembro(Membros membro) {
        membros.add(membro);
    }

    public List<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    public void contratarBibliotecario(Bibliotecario bibliotecario) {
        bibliotecarios.add(bibliotecario);
    }

    public List<Livro> getLivrosDisponiveis() {
        List<Livro> livrosDisponiveis = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.podeSerEmprestado()) {
                livrosDisponiveis.add(livro);
            }
        }
        return livrosDisponiveis;
    }

    public List<Livro> getAcervo() {
        return acervo;
    }

    public List<Emprestimo> getEmprestimosAtivos() {
        return emprestimos;
    }

    public List<Membros> getMembros() {
        return membros;
    }
}