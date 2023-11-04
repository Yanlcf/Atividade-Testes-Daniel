import com.example.Bibliotecario;
import com.example.Livro;
import com.example.Membros;
import com.example.Emprestimo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class EmprestimoTest {

    @Test
    public void Emprestimo() {
        Livro livroMock = mock(Livro.class);
        Membros membroMock = mock(Membros.class);
        Bibliotecario bibliotecarioMock = mock(Bibliotecario.class);
        String dataEmprestimo = "22/03/2024";
        String dataDevolucao = "30/03/2024";
        

        when(livroMock.getTitulo()).thenReturn("Dom Casmurro");
        when(membroMock.getNome()).thenReturn("Fulano");
        when(bibliotecarioMock.getNome()).thenReturn("Ciclano");

        Emprestimo emprestimo = new Emprestimo(livroMock, membroMock, bibliotecarioMock, dataEmprestimo, dataDevolucao);

        assertEquals("Dom Casmurro", emprestimo.getLivro().getTitulo());
        assertEquals("Fulano", emprestimo.getMembro().getNome());
        assertEquals("Ciclano", emprestimo.getBibliotecario().getNome());

        verify(livroMock).getTitulo();
        verify(membroMock).getNome();
        verify(bibliotecarioMock).getNome();
    }

    @Test
    public void EmprestimoData() {
        Livro livroMock = Mockito.mock(Livro.class);
        Membros membroMock = Mockito.mock(Membros.class);
        Bibliotecario bibliotecarioMock = Mockito.mock(Bibliotecario.class);
        String dataEmprestimo = "22/03/2024";
        String dataDevolucao = "30/03/2024";
    
        when(livroMock.getTitulo()).thenReturn("A Menina que Roubava Livros");
        when(membroMock.getNome()).thenReturn("Beltrano");
        when(bibliotecarioMock.getNome()).thenReturn("Fulano");
    
        Emprestimo emprestimo = new Emprestimo(livroMock, membroMock, bibliotecarioMock, dataEmprestimo, dataDevolucao);
    
        assertEquals(dataEmprestimo, emprestimo.getDataEmprestimo());
        assertEquals(dataDevolucao, emprestimo.getDataDevolucao());
        
        livroMock.getTitulo();
        membroMock.getNome();
        bibliotecarioMock.getNome(); //Invocando os métodos para o Verify ver se houve invocação...

        verify(livroMock, times(1)).getTitulo();
        verify(membroMock).getNome();
        verify(bibliotecarioMock).getNome();
    }

    @Test
    public void EmprestimoAcesso() {

    Livro livroMock = Mockito.mock(Livro.class);
    Membros membroMock = Mockito.mock(Membros.class);
    Bibliotecario bibliotecarioMock = Mockito.mock(Bibliotecario.class);
    String dataEmprestimo = "22/03/2024";
    String dataDevolucao = "30/03/2024";

    when(livroMock.getTitulo()).thenReturn("A Menina que Roubava Livros");
    when(membroMock.getNome()).thenReturn("Beltrano");
    when(bibliotecarioMock.getNome()).thenReturn("Fulano");

    Emprestimo emprestimo = new Emprestimo(livroMock, membroMock, bibliotecarioMock, dataEmprestimo, dataDevolucao);

    assertEquals(livroMock, emprestimo.getLivro());
    assertEquals(membroMock, emprestimo.getMembro());
    assertEquals(bibliotecarioMock, emprestimo.getBibliotecario());
    assertEquals(dataEmprestimo, emprestimo.getDataEmprestimo());
    assertEquals(dataDevolucao, emprestimo.getDataDevolucao());

    livroMock.getTitulo();
    membroMock.getNome();
    bibliotecarioMock.getNome();

    verify(livroMock).getTitulo();
    verify(membroMock).getNome();
    verify(bibliotecarioMock).getNome();
}

    @Test
    public void PegarLivro() {

    Livro livroMock = Mockito.mock(Livro.class);
    Membros membroMock = Mockito.mock(Membros.class);
    Bibliotecario bibliotecarioMock = Mockito.mock(Bibliotecario.class);
    String dataEmprestimo = "22/03/2024";
    String dataDevolucao = "30/03/2024";

    when(livroMock.getTitulo()).thenReturn("Vingadores");
    when(membroMock.getNome()).thenReturn("Beltrano");
    when(bibliotecarioMock.getNome()).thenReturn("Fulano");

    Emprestimo emprestimo = new Emprestimo(livroMock, membroMock, bibliotecarioMock, dataEmprestimo, dataDevolucao);

    emprestimo.pegarLivro();

    assertFalse(livroMock.podeSerEmprestado());
    assertEquals("Beltrano",membroMock.getNome());
    assertEquals("Fulano", bibliotecarioMock.getNome());

    livroMock.podeSerEmprestado();

    verify(livroMock,times(2)).podeSerEmprestado();
}

    @Test
    public void MembroPossuiE() {

    Livro livroMock = mock(Livro.class);
    Membros membroMock = mock(Membros.class);
    Bibliotecario bibliotecarioMock = mock(Bibliotecario.class);
    String dataEmprestimo = "22/03/2024";
    String dataDevolucao = "30/03/2024";
    
    // Configurando o comportamento do mock
    when(membroMock.possuiLivrosEmprestados()).thenReturn(true);
    
    // Executando o método a ser testado
    Emprestimo emprestimo = new Emprestimo(livroMock, membroMock, bibliotecarioMock, dataEmprestimo, dataDevolucao);
    
    membroMock.possuiLivrosEmprestados();
    // Verificando se o membro possui um empréstimo
    verify(membroMock).possuiLivrosEmprestados();
    }

}

