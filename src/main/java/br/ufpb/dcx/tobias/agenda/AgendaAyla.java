package br.ufpb.dcx.tobias.agenda;

import java.io.IOException;
import java.util.*;

public class AgendaAyla implements InterfaceAgenda{
    private Map<String, Contato> contatos;

    public AgendaAyla() {
        contatos = new HashMap<String, Contato>();
    }


    @Override
    public boolean cadastraContato(String nome, int dia, int mes) {
        if(contatos.containsKey(nome)){
            return false;
        }
        Contato contato = new Contato(nome, dia, mes);
        contatos.put(contato.getNome(), contato);
        return true;
    }

    @Override
    public Collection<Contato> pesquisaAniversariantes(int dia, int mes) {
        Collection<Contato> contatosAniversariantes = new ArrayList<Contato>();
        for(String key : contatos.keySet()){
            if(contatos.get(key).getDiaAniversario() == dia && contatos.get(key).getMesAniversario() == mes){
                contatosAniversariantes.add(contatos.get(key));
            }
        }
        return contatosAniversariantes;
    }

    @Override
    public boolean removeContato(String nome) throws ContatoInexistenteException {
        if(contatos.containsKey(nome)){
            contatos.remove(nome);
            return true;
        }
        throw new ContatoInexistenteException();
    }

    @Override
    public void salvarDados() throws IOException {

    }

    @Override
    public void recuperarDados() throws IOException {

    }
}
