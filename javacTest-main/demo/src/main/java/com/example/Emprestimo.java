package com.example;

public class Emprestimo {
    private Livro livro;
    private Membros membro;
    private Bibliotecario bibliotecario;
    String dataEmprestimo;
    String dataDevolucao;

    public Emprestimo(Livro livro, Membros membro, Bibliotecario bibliotecario, String dataEmprestimo, String dataDevolucao) {
        this.livro = livro;
        this.membro = membro;
        this.bibliotecario = bibliotecario;
        this.dataDevolucao = dataDevolucao;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public Membros getMembro() {
        return membro;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void pegarLivro() {
        this.livro.emprestar();
        this.livro.setMembro(this.membro);
        this.livro.setEmprestimo(this);
        this.livro.setBibliotecarioResponsavel(this.bibliotecario);
    }


}
