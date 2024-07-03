package demo;

import org.junit.jupiter.api.Test;

import static demo.CoverageDemo.multiply;
import static org.junit.jupiter.api.Assertions.*;

class TestCoverageDemo {

    @Test
    void testEquilateral() {
        assertEquals(4, multiply(2, 2));
    }

}
