package br.ufpb.dcx.tobias.agenda;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class AgendaAylaTest {

    @Test
    public void testaCadastroEPesquisaERemoção() {
        AgendaAyla agenda = new AgendaAyla();
        Collection<Contato> contatosEncontrado = agenda.pesquisaAniversariantes(21,9);
        assertTrue(contatosEncontrado.isEmpty());
        agenda.cadastraContato("Zé",21,9);
        agenda.cadastraContato("Jonas",21,9);
        contatosEncontrado = agenda.pesquisaAniversariantes(21,9);
        assertEquals(2, contatosEncontrado.size());
        Contato Zé = new Contato("Zé",21,9);
        assertTrue(contatosEncontrado.contains(Zé));
        Contato Jonas = new Contato("Jonas",21,9);
        assertTrue(contatosEncontrado.contains(Jonas));
        try{
            agenda.removeContato("Jonas");
        }catch(ContatoInexistenteException e){
            fail("Lançou exceção!");
        }

    }
}
