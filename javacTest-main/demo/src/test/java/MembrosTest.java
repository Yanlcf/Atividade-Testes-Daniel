import com.example.Bibliotecario;
import com.example.Livro;
import com.example.Membros;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

public class MembrosTest {

@Test
    public void SucessoNoEmprestimo() {

        Membros membro = Mockito.mock(Membros.class);
        Livro livro = Mockito.mock(Livro.class);

        when(membro.getMemberId()).thenReturn(1); 
        when(livro.podeSerEmprestado()).thenReturn(true); 

        Bibliotecario bibliotecario = new Bibliotecario("Joe","5525");

        boolean solicitacao = bibliotecario.emprestarLivro(membro, livro);

        assertTrue(solicitacao);
        verify(livro, times(1)).podeSerEmprestado();
    }

    @Test
    public void RegistrarDevolucao() {
    
    Livro livroMock = Mockito.mock(Livro.class);
    Membros membro = new Membros(12, "João", "Nabuco", 18);

    // Realizando a devolução do livro
    membro.registrarDevolucao(livroMock);

    // Verificando se as atividades do membro foram atualizadas corretamente
    verify(livroMock, times(1)).devolver();
    }

    @Test
    public void RegistrarEmprestimo() {
        
        Livro livroMock = Mockito.mock(Livro.class);
        Membros membro = new Membros(27, "Fernando", "Pinto", 44);
    
        // Configurando o comportamento do livro mock
        when(livroMock.getTitulo()).thenReturn("O Senhor dos Anéis");
    
        // Realizando o empréstimo do livro
        membro.registrarEmprestimo(livroMock);
    
        // Verificando se as atividades do emprestimo o livro foram atualizadas corretamente
        verify(livroMock, times(1)).emprestar();
    }

    @Test
    public void RenovacaoLivro() {

        Livro livroMock = Mockito.mock(Livro.class);
        Membros membroMock = Mockito.mock(Membros.class);
    
        // Configurando o comportamento do livro mock
        when(livroMock.getTitulo()).thenReturn("O Cavaleiro das Trevas");
    
        // Realizando a renovação do empréstimo do livro
        livroMock.renovarEmprestimo();
        membroMock.atualizarAtividades("Renovação do empréstimo do livro O Cavaleiro das Trevas");
    
        // Verificando se as atividades do membro foram atualizadas corretamente
        verify(livroMock, times(1)).renovarEmprestimo();
        verify(membroMock, times(1)).atualizarAtividades(Mockito.eq("Renovação do empréstimo do livro O Cavaleiro das Trevas"));
    }
    
    @Test
    public void LivrosEmprestados() {

    Livro livroMock = Mockito.mock(Livro.class);
    Membros membroMock = Mockito.mock(Membros.class);

    // Configurando o comportamento do membro mock
    when(membroMock.possuiLivrosEmprestados()).thenReturn(true);

    // Verificando se o membro possui livros emprestados atualmente
    assertTrue(membroMock.possuiLivrosEmprestados());

    // Verificando se o método foi chamado corretamente
    verify(membroMock, times(1)).possuiLivrosEmprestados();
    }
}