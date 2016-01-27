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

}
