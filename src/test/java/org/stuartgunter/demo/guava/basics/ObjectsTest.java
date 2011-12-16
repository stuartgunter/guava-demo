package org.stuartgunter.demo.guava.basics;

import com.google.common.base.Objects;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * User: gunters
 * Created: 01/12/2011 10:01
 */
@Test
public class ObjectsTest {

    private Person person;

    @BeforeMethod
    public void setup() {
        person = new Person(1, "Bob", "Smith");
    }

    public void shouldGetFirstNonNullItem() {
        assertEquals("first", Objects.firstNonNull("first", "second"));
        assertEquals("second", Objects.firstNonNull(null, "second"));

        assertEquals(person, Objects.firstNonNull(null, person));
    }

    public void shouldGetPersonAsString() {
        final String expected = "Person{id=1, Bob, Smith}";

        assertEquals(expected, person.toString());
    }
}
