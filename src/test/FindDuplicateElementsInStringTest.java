package test;

import main.easy.FindDuplicateElementsInString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class FindDuplicateElementsInStringTest {

    private Logger logger = LogManager.getLogger(FindDuplicateElementsInString.class);

    @BeforeEach
    public void setUp() {
        logger.info("Initializing FindDuplicateElementsInStringTest");
    }

    @Test
    public void testValidInput() {
        Assertions.assertEquals(FindDuplicateElementsInString.returnDuplicates("happy"),
                "p");

        Assertions.assertEquals(FindDuplicateElementsInString.returnDuplicates("abc"),
                "");

        Assertions.assertEquals(FindDuplicateElementsInString.returnDuplicates("aaadsss"),
                "as");

        Assertions.assertEquals(FindDuplicateElementsInString.returnDuplicates("EQSCBASDDS"),
                "sd");
    }

    @Test
    public void testInvalidInput() {
        Assertions.assertEquals(FindDuplicateElementsInString.returnDuplicates(""), "");
        Assertions.assertEquals(FindDuplicateElementsInString.returnDuplicates("233"), "3");
        Assertions.assertEquals(FindDuplicateElementsInString.returnDuplicates("!w2rx$42"), "2");
        Assertions.assertEquals(FindDuplicateElementsInString.returnDuplicates("    "), "");
        Assertions.assertEquals(FindDuplicateElementsInString.returnDuplicates("!das412$@$@"), "$@");
    }
}
