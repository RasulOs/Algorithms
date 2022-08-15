package test;

import main.medium.NextGreaterNumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NextGreaterNumberTest {

    private static Logger logger;

    @BeforeEach
    public void setUp() {
        logger = LogManager.getLogger(NextGreaterNumberTest.class);
        logger.info("Initializing NextGreaterNumberTest");
    }

    @Test
    public void testValidNumber() {
        assertEquals(NextGreaterNumber.PermutationStep(312), 321);
        assertEquals(NextGreaterNumber.PermutationStep(343215), 343251);
        assertEquals(NextGreaterNumber.PermutationStep(498764321), 612344789);
        assertEquals(NextGreaterNumber.PermutationStep(21932), 22139);
        assertEquals(NextGreaterNumber.PermutationStep(854248), 854284);
        assertEquals(NextGreaterNumber.PermutationStep(21331), 23113);
        assertEquals(NextGreaterNumber.PermutationStep(23210), 30122);
    }

    @Test
    public void testEdgeCases() {
        assertEquals(NextGreaterNumber.PermutationStep(4321), -1);
        assertEquals(NextGreaterNumber.PermutationStep(1), -1);
        assertEquals(NextGreaterNumber.PermutationStep(0), -1);
        assertEquals(NextGreaterNumber.PermutationStep(10), -1);
    }
}
