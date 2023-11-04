import com.example.Bibliotecario;
import com.example.Livro;
import com.example.Membros;
import com.example.Emprestimo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;



public class EmprestimoTest {

    @Test
    public void testEmprestimo() {
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
public void testEmprestimoData() {
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

}


}
