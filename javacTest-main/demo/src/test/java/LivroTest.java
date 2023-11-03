import com.example.Bibliotecario;
import com.example.Livro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LivroTest {

@Test
public void testBibliotecRespon() { 
    //O teste tem como intuito verificar o bibliotecario responsável pelo livro e verificar seu cadastramento.

    // Criando o Mockito para Bibliotecario
    Bibliotecario bibliotecarioMock = Mockito.mock(Bibliotecario.class);
    // Preenchendo a instancia do Livro
    Livro livro = new Livro("Dom Quixote", "Miguel", "46513254");
    // Cadastrando os dados no Array atividades
    bibliotecarioMock.cadastrarLivro(livro); 
    // Setando que o bibliotecario do Mock é o responsável pelo livro em questão
    livro.setBibliotecarioResponsavel(bibliotecarioMock);
    // Verificando se o bibliotecario responsável é existente.
    assertEquals(bibliotecarioMock, livro.getBibliotecarioResponsavel()); 
    //Fazendo ERRO PROPOSITAL para que se há duas verifições 
    verify(bibliotecarioMock, times(2)).cadastrarLivro(livro); 
}

@Test
public void HaEmprestPorBibliotecario() {
    //Teste com o intuito de verificar se o livro pode ser emprestado e se a ação de emprestimo foi realizada uma vez.

    // Criando um mock de Bibliotecario
    Bibliotecario bibliotecarioMock = Mockito.mock(Bibliotecario.class);
    // Cria um livro que pode ser emprestado
    Livro livro = new Livro("Jogador Nº 1", "Ernest", "654654");
    // Definindo se o livro pode ser emprestado
    when(bibliotecarioMock.podeRealizarEmprestimo(livro)).thenReturn(true);
    // Tenta emprestar o livro
    boolean emprestado = (boolean) bibliotecarioMock.podeRealizarEmprestimo(livro);
    // Verifica se o livro pode ser emprestado
    assertTrue(emprestado);
    // Verifica se o método 'podeRealizarEmprestimo' foi chamado uma vez com o livro fornecido
    verify(bibliotecarioMock, times(1)).podeRealizarEmprestimo(livro);
}

@Test
public void testRegistroDePerdLivro() {
    //O teste tem como intuito verificar se houve o registro da perda do livro criado na instância, e se o método foi feito uma vez.

    // Cria um mock de Bibliotecario
    Bibliotecario bibliotecarioMock = Mockito.mock(Bibliotecario.class);
    
    // Cria um livro
    Livro livro = new Livro("O Pequeno Príncipe", "Antoine", "9841561");
    
    // Registra a perda do livro
    bibliotecarioMock.registrarPerda(livro);
    
    // Verifica se o método 'registrarPerda' foi chamado uma vez com o livro fornecido
    verify(bibliotecarioMock, times(1)).registrarPerda(livro);
}

@Test
public void testRegistrDevoluLivro() {
    //O teste tem como intuito verificar o registro da devolução do livro da instância, e verificar se o método foi chamado uma vez.

    // Cria um mock de Bibliotecario
    Bibliotecario bibliotecarioMock = Mockito.mock(Bibliotecario.class);
    // Cria um livro
    Livro livro = new Livro("A Culpa eh das Estrelas", "John", "54649871");
    // Registra a devolução do livro
    bibliotecarioMock.registrarDevolucao(livro);
    // Verifica se o método 'registrarDevolucao' foi chamado uma vez com o livro fornecido
    verify(bibliotecarioMock, times(1)).registrarDevolucao(livro);
}

@Test
public void testRegistrEmprestiLivro() {
    //O teste tem como objetivo registrar o empréstimo de um livro por um leito, e verificar se sua chamada foi uma única vez.

    // Cria um mock de Bibliotecario
    Bibliotecario bibliotecarioMock = Mockito.mock(Bibliotecario.class);
    // Cria um livro
    Livro livro = new Livro("O Ladrao de Raios", "Rick", "786542");
    // Registra o empréstimo do livro, passando o objeto e o nome do leitor.
    bibliotecarioMock.realizarEmprestimo(livro, "João");
    
    // Verifica se o método 'realizarEmprestimo' foi chamado uma vez com o livro fornecido e o usuário "João"
    verify(bibliotecarioMock, times(1)).realizarEmprestimo(livro, "João");

    }
}

