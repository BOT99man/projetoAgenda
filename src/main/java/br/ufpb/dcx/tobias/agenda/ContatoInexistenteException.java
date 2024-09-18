package br.ufpb.dcx.tobias.agenda;

public class ContatoInexistenteException extends Exception{
    public ContatoInexistenteException(){
        super("Contato inexistente");
    }
    public ContatoInexistenteException(String msg){
        super(msg);
    }
}
