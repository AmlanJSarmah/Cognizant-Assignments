package TDD;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Exercise4Test {
    private Exercise4 calc;

    @Before
    public void setUp() {
        calc = new Exercise4();
    }

    @After
    public void tearDown() {
        calc = null;
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 5, b = 3;
        // Act
        int result = calc.add(a, b);
        // Assert
        assertEquals(8, result);
    }

    @Test
    public void testSubtract() {
        // Arrange
        int a = 10, b = 4;
        // Act
        int result = calc.subtract(a, b);
        // Assert
        assertEquals(6, result);
    }
}
