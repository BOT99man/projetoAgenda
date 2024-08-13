package br.ufpb.dcx.tobias.agenda;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ContatoTest {
   @Test
    public void testaConstrutor(){
        Contato c1 = new Contato("Tobias", 01,03);
        assertEquals("Tobias",c1.getNome());
        assertEquals(01,c1.getDiaAniversario());
        assertEquals(03,c1.getMesAniversario());
    }
}
