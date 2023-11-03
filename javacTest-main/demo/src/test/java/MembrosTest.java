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

public class MembrosTest {

@Test
    public void testeEmprestimoBemSucedido() {
        // Criar mocks de objetos necessários
        Membros membro = Mockito.mock(Membros.class);
        Livro livro = Mockito.mock(Livro.class); // Supomos que você tenha uma classe 'Livro'

        // Configurar comportamento simulado usando 'when'
        when(membro.getMemberId()).thenReturn(1); // Simula o ID do membro
        when(livro.podeSerEmprestado()).thenReturn(true); // Simula que o livro está disponível

        // Criar um bibliotecário
        Bibliotecario bibliotecario = new Bibliotecario("Joe","5525");

        // Executar o empréstimo
        boolean resultado = bibliotecario.emprestarLivro(membro, livro);

        // Verificar se o empréstimo foi bem-sucedido usando 'verify'
        assertTrue(resultado); // Verificar se o resultado é verdadeiro (bem-sucedido)
        verify(livro, times(1)).podeSerEmprestado(); // Verificar se 'podeSerEmprestado' foi chamado exatamente uma vez no objeto 'livro'

    }
}