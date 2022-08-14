package test;


import main.medium.MissingDigit;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MissingDigitTest {


    private static Logger logger;

    @BeforeEach
    public void setUp() {
        logger = LogManager.getLogger(MissingDigitTest.class);

        logger.info("Initializing MissingDigitTest");

    }

    @Test
    public void testLhs1() {
        assertEquals(MissingDigit.missingDigit("x + 3 = 4"), "1");
        assertEquals(MissingDigit.missingDigit("1x + 25 = 35"), "0");
        assertEquals(MissingDigit.missingDigit("x3 + 20 = 113"), "9");
        assertEquals(MissingDigit.missingDigit("x5 - 20 = 35"), "5");
        assertEquals(MissingDigit.missingDigit("x3 * 3 = 39"), "1");
        assertEquals(MissingDigit.missingDigit("2x / 7 = 3"), "1");
    }

    @Test
    public void testLhs2() {
        assertEquals(MissingDigit.missingDigit("20 + 10x = 125"), "5");
        assertEquals(MissingDigit.missingDigit("20 + x3 = 53"), "3");
        assertEquals(MissingDigit.missingDigit("39 - x3 = 6"), "3");
        assertEquals(MissingDigit.missingDigit("72 / x = 9"), "8");
        assertEquals(MissingDigit.missingDigit("8 * x = 56"), "7");

    }

    @Test
    public void testRhs() {
        assertEquals(MissingDigit.missingDigit("20 + 100 = x20"), "1");
        assertEquals(MissingDigit.missingDigit("35 - 13 = 2x"), "2");
        assertEquals(MissingDigit.missingDigit("20 + 105 = x25"), "1");
        assertEquals(MissingDigit.missingDigit("20 + 33 = 5x"), "3");
        assertEquals(MissingDigit.missingDigit("39 - 33 = x"), "6");
        assertEquals(MissingDigit.missingDigit("72 / 8 = x"), "9");
        assertEquals(MissingDigit.missingDigit("8 * 7 = x6"), "5");
    }
}