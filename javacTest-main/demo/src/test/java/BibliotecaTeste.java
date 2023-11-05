import com.example.Biblioteca;
import com.example.Bibliotecario;
import com.example.Emprestimo;
import com.example.Livro;
import com.example.Membros;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BibliotecaTeste {
    

    // TESTE 1 - ADICIONAR LIVRO AO ACERVO
    @Test
    public void testAdicionarLivro() {
    
        Livro livroMock = Mockito.mock(Livro.class);
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro(livroMock);

        // Verificar se o livro foi adionado ao acervo
        assertTrue(biblioteca.getAcervo().contains(livroMock));
    }

    // 2 - TESTAR CONTRATAÇÃO BIBLIOTECARIO 

    @Test
    public void testContratarBibliotecario() {

        Bibliotecario bibliotecarioMock = Mockito.mock(Bibliotecario.class);
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.contratarBibliotecario(bibliotecarioMock);

        // Verificando se o contratar deu certo. 
        assertEquals(1, biblioteca.getBibliotecarios().size());
    }

    // 3 - TESTAR SE O RETORNO DE LIVRO DISPONIVEIS ESTÁ OKK.

    @Test
    public void testGetLivrosDisponiveis() {
    
        Biblioteca biblioteca = new Biblioteca();

        // Vamos testar com dois livros.
        Livro livro1 = Mockito.mock(Livro.class);
        Livro livro2 = Mockito.mock(Livro.class);

        // Um deles pode ser emprestado, já o outro não. Para testar se o get tá correto.
        when(livro1.podeSerEmprestado()).thenReturn(true);
        when(livro2.podeSerEmprestado()).thenReturn(false);

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);

        // Vamos colocar o livros disponíveis aqui.
        List<Livro> livrosDisponiveis = biblioteca.getLivrosDisponiveis();

        // Agora vamos ver se apenas tem um, sinalizando que o outro não foi incluso.
        assertEquals(1, livrosDisponiveis.size());
        assertTrue(livrosDisponiveis.contains(livro1));
        assertFalse(livrosDisponiveis.contains(livro2));
    }

    // 4 - CADASTRAR UM MEMBRO TESTE.

    @Test
    public void testCadastrarMembro() {
     
        Biblioteca biblioteca = new Biblioteca();
        Membros membroMock = mock(Membros.class);
        biblioteca.cadastrarMembro(membroMock);
        // Agora vamos ver se o membro está na lista de membros.
        assertTrue(biblioteca.getMembros().contains(membroMock));
    }

    // 5 - TESTAR O MÉTODO DE EMPRESTIMOS ATIVOS

    @Test
    public void testGetEmprestimosAtivos() {
        Biblioteca biblioteca = new Biblioteca();

        // Criando alguns emprestimos ativos.
        Emprestimo emprestimo1 = Mockito.mock(Emprestimo.class);
        Emprestimo emprestimo2 = Mockito.mock(Emprestimo.class);
        
        // Adicionando a lista de emprestimmos.
        biblioteca.getEmprestimosAtivos().add(emprestimo1);
        biblioteca.getEmprestimosAtivos().add(emprestimo2);

        // Obter emprestimos ativos
        List<Emprestimo> emprestimosAtivos = biblioteca.getEmprestimosAtivos();
        
        // Verificando se os que adicionamos está na lista. 
        assertTrue(emprestimosAtivos.contains(emprestimo1));
        assertTrue(emprestimosAtivos.contains(emprestimo2));
    }

    
}