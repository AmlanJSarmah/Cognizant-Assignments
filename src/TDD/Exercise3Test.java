package TDD;

import org.junit.Test;
import static org.junit.Assert.*;

public class Exercise3Test {
    private Exercise3 obj = new Exercise3();

    @Test
    public void testAssertions() {
        assertEquals(5, obj.add(2, 3));
        assertTrue(obj.isGreater(5, 3));
        assertFalse(obj.isLess(5, 3));
        assertNull(obj.maybeNull(true));
        assertNotNull(obj.maybeNull(false));
    }
}
