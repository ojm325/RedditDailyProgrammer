/**
 * Created by Omar on 1/26/2016.
 */
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class VHSRecordingProblemTest {
    VHSRecordingProblem test = new VHSRecordingProblem();
    @Test
    public void test1(){
        List<String>file = fileReader("VHSRecordingProblemInput1.txt");
        assertEquals("3", test.solveMain(file, "Normal"));
    }

    @Test
    public void test2(){
        List<String>file = fileReader("VHSRecordingProblemInput2.txt");
        assertEquals("4", test.solveMain(file, "Normal"));
    }

    @Test
    public void test3(){
        List<String>file = fileReader("VHSRecordingProblemInput3.txt");
        assertEquals("3", test.solveMain(file, "Normal"));
    }

    /*
    @Test
    public void bonus1(){
        assertEquals("2015-02-13", test.validate("2/13/15"));
    }

    @Test
    public void bonus2(){ assertEquals("2010-01-31", test.validate("1-31-10")); }
    */

    public static List fileReader(String fileName){
        List<String>text = new ArrayList<>();


        try{
            text = Files.readAllLines(Paths.get("C:\\Users\\Omar\\IdeaProjects\\RedditDailyProgrammer\\test\\java\\VHSRecordingProblemInputs\\"+fileName));
        } catch(Exception e){
            e.printStackTrace();
        }

        return text;
    }
}
