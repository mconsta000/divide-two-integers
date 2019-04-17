package org.mconsta000.divide;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    private App app = new App();

    @Test
    public void testApp() {
        assertEquals(5, app.divide(10,2));
    }
}
