package org.stuartgunter.demo.guava.basics;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * User: gunters
 * Created: 02/12/2011 16:36
 */
@Test
public class PreconditionsTest {

    private Person person;

    @BeforeMethod
    public void setup() {
        person = new Person(0, "Stuart", "Gunter");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldNotAllowNegativeId() {
        person.setId(-1);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void shouldNotAllowNullParameter() {
        person.setFirstName(null);
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void shouldNotAllowLastNameChange() {
        person.setLastName("Surname");
    }
}
