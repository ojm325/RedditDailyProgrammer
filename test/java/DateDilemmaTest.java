import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Omar on 1/25/2016.
 */
public class DateDilemmaTest {
    DateDilemma test = new DateDilemma();

    @Test
    public void test1(){
        assertEquals("2015-02-13", test.validate("2/13/15"));
    }

    @Test
    public void test2(){
        assertEquals("2010-01-31", test.validate("1-31-10"));
    }

    @Test
    public void test3(){
        assertEquals("2010-01-31", test.validate("1-31-10"));
    }

    @Test
    public void test4(){
        assertEquals("2015-05-10", test.validate("5 10 2015"));
    }
    @Test
    public void test5(){
        assertEquals("2012-03-17", test.validate("2012 3 17"));
    }
    @Test
    public void test6(){
        assertEquals("2001-01-01", test.validate("2001-01-01"));
    }
    @Test
    public void test7(){
        assertEquals("2008-01-07", test.validate("2008/01/07"));
    }
}