package br.ufpb.dcx.tobias.agenda;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class GravadorDeDadosTest {

    @Test
    public void testaGravadorDeDados() throws IOException {
        File arquivoContato = new File(GravadorDeDados.ARQUIVO_CONTATOS);
        if(!arquivoContato.exists()){
            arquivoContato.delete();
        }
        GravadorDeDados gravaDados = new GravadorDeDados();
        File arquivo = new File(GravadorDeDados.ARQUIVO_CONTATOS);
        assertFalse(arquivo.exists());
        HashMap<String, Contato> contatos = new HashMap<>();
        contatos.put("Tobias", new Contato("Tobias",1,3));
        gravaDados.salvaContato(contatos);
        assertTrue(arquivo.exists());
        arquivo.delete();
    }

    @Test
    public void testaRecuperacao() throws IOException {
        File aquivoContato = new File(GravadorDeDados.ARQUIVO_CONTATOS);
        if(aquivoContato.exists()){
            aquivoContato.delete();
        }
        GravadorDeDados gravaDados = new GravadorDeDados();
        File arquivo = new File(GravadorDeDados.ARQUIVO_CONTATOS);
        assertFalse(arquivo.exists());
        HashMap<String, Contato> contatos = new HashMap<>();
        contatos.put("Tobias", new Contato("Tobias",1,3));
        gravaDados.salvaContato(contatos);
        assertTrue(arquivo.exists());
        HashMap<String,Contato> contatosRecuperados = gravaDados.recuperaContatos();
        Contato c2 = contatosRecuperados.get("Tobias");
        assertEquals("Tobias",c2.getNome());
        assertEquals(1,c2.getDiaAniversario());
        assertEquals(3,c2.getMesAniversario());
        arquivo.delete();
    }
}
