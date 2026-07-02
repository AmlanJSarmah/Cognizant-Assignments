package TDD;

import org.junit.Test;
import static org.junit.Assert.*;

public class Exercise2Test {
    private Exercise2 calc = new Exercise2();

    @Test
    public void testAdd() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(2, calc.subtract(5, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(12, calc.multiply(4, 3));
    }

    @Test
    public void testDivide() {
        assertEquals(5, calc.divide(10, 2));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calc.divide(10, 0);
    }

    @Test
    public void testIsEvenTrue() {
        assertTrue(calc.isEven(4));
    }

    @Test
    public void testIsEvenFalse() {
        assertFalse(calc.isEven(7));
    }
}
