package Tools;
import org.junit.*;
import static org.junit.Assert.*;
import Tools.CalendarHandler;

/**
 * Unit tests for CPFHandler class.
 */

public class CalendarHandlerTest{
    /**
     * Unit test for isValid method.
     */
    @Test
    public void testCalendarBuilder(){
        CalendarHandler cHandler = new CalendarHandler(05, 2019);
        String calendarString = cHandler.CalendarBuilder();
        String expectedString = "Maio 2019\nDo Se Te Qu Qu Se Sa \n          1  2  3  4 \n 5  6  7  8  9 10 11 \n12 13 14 15 16 17 18 \n19 20 21 22 23 24 25 \n26 27 28 29 30 31    \n                     \n";
        System.out.println(expectedString);
        System.out.println(calendarString);

        assertEquals(expectedString, calendarString);
        //fail();
    }
    
    @Test
    public void testCalendarHandlerConstructor(){
        CalendarHandler cHandler = new CalendarHandler(05, 2019);
        System.out.println(cHandler);
        //assertTrue("Exception", true);
        //fail();
    }

}
