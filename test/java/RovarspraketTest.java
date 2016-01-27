import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by omar on 1/27/16.
 */
public class RovarspraketTest {
    Rovarspraket test = new Rovarspraket();

    @Test
    public void test1(){
        assertEquals("Jojagog totalolaror Rorövovarorsospoproråkoketot!", test.solve("Jag talar Rövarspråket!"));
    }

    @Test
    public void test2(){
        assertEquals("I'mom sospopeakokinongog Rorobobboberor'sos lolanongoguagoge!", test.solve("I'm speaking Robber's language!"));
    }

    @Test
    public void bonus1(){
        assertEquals("Jag talar Rövarspråket!", test.decode("Jojagog totalolaror Rorövovarorsospoproråkoketot!"));
    }

    @Test
    public void bonus2(){
        assertEquals("Popol Vuh", test.decode("Popopopol Vovuhoh"));
    }

}
