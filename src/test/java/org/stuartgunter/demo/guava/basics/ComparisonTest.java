package org.stuartgunter.demo.guava.basics;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

/**
 * User: gunters
 * Created: 05/12/2011 08:31
 */
@Test
public class ComparisonTest {

    public void shouldComparePersons() {
        final Person p1 = new Person(0, "Stuart", "Gunter");
        final Person p2 = new Person(0, "Stuart", "Gunter");
        final Person p3 = new Person(0, "Stuart", "Other");

        assertTrue(p1.compareTo(p2) == 0);
        assertTrue(p1.compareTo(p3) < 0);
    }
}
