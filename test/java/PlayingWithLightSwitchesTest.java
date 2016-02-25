import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Omar on 2/25/2016.
 */
public class PlayingWithLightSwitchesTest {
    PlayingWithLightSwitches test = new PlayingWithLightSwitches();

    @Test
    public void test1(){
        assertEquals(7, test.solve("PlayingWithLightSwitchesInput1.txt"));
    }

    @Test
    public void test2(){
        assertEquals(423, test.solve("PlayingWithLightSwitchesInput2.txt"));
    }
}
