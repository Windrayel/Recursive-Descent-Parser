import org.junit.Test;

import static org.junit.Assert.*;
public class MainTest {
    @Test
    public void isDerivable() {
        assertFalse(Main.isDerivable("a"));
        assertTrue(Main.isDerivable("aa"));
        assertTrue(Main.isDerivable("ababab"));
        assertTrue(Main.isDerivable("abaabcabaab"));
    }
}