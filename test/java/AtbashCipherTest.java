import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by Omar on 2/20/2016.
 */
public class AtbashCipherTest {
    AtbashCipher test = new AtbashCipher();

    @Test
    public void test1(){
        assertEquals("ullyzi", test.solve("foobar"));
    }

    @Test
    public void test2(){
        assertEquals("draziw", test.solve("wizard"));
    }

    @Test
    public void test3(){
        assertEquals("/i/wzrobkiltiznnvi", test.solve("/r/dailyprogrammer"));
    }

    @Test
    public void test4(){
        assertEquals("this is an example of the atbash cipher", test.solve("gsrh rh zm vcznkov lu gsv zgyzhs xrksvi"));
    }

    @Test
    public void bonus1(){
        assertEquals("/I/wzrObkiLtiznNvi", test.solve("/R/daiLyprOgramMer"));
    }
}
