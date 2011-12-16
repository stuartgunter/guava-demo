package org.stuartgunter.demo.guava.basics;

import com.google.common.base.Strings;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

/**
 * User: gunters
 * Created: 01/12/2011 10:10
 */
@Test
public class StringsTest {

    private static final String EMPTY = "";
    private static final String NON_EMPTY = "Non-Empty";

    public void shouldHandleNulls() {
        // emptyToNull
        assertNull(Strings.emptyToNull(EMPTY));
        assertEquals(NON_EMPTY, Strings.emptyToNull(NON_EMPTY));

        // nullToEmpty
        assertEquals(EMPTY, Strings.nullToEmpty(null));
        assertEquals(NON_EMPTY, Strings.nullToEmpty(NON_EMPTY));

        // isNullOrEmpty
        assertTrue(Strings.isNullOrEmpty(EMPTY));
        assertTrue(Strings.isNullOrEmpty(null));
        assertFalse(Strings.isNullOrEmpty(NON_EMPTY));
    }

    public void shouldCreateStrings() {
        // padStart
        assertEquals("xxxx" + NON_EMPTY, Strings.padStart(NON_EMPTY, 13, 'x'));
        assertEquals(NON_EMPTY, Strings.padStart(NON_EMPTY, 1, 'x'));

        // padEnd
        assertEquals(NON_EMPTY + "xxxx", Strings.padEnd(NON_EMPTY, 13, 'x'));
        assertEquals(NON_EMPTY, Strings.padEnd(NON_EMPTY, 1, 'x'));

        // repeat
        assertEquals("xyzxyz", Strings.repeat("xyz", 2));
    }
}
