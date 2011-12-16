package org.stuartgunter.demo.guava.collections;

import org.stuartgunter.demo.guava.basics.Person;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.annotation.Nullable;
import java.util.Collection;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * User: gunters
 * Created: 05/12/2011 09:05
 */
@Test
public class Collections2Test {

    private Collection<Person> people;

    @BeforeMethod
    public void setup() {
        people = Lists.newArrayList(
                new Person(0, "First", "Person"),
                new Person(1, "Mary", "Jones"),
                new Person(2, "Michael", "Parker")
        );
    }

    public void shouldFilterCollection() {
        final Collection<Person> filtered = Collections2.filter(people,
                new Predicate<Person>() {
                    public boolean apply(@Nullable Person input) {
                        return input != null && input.getFirstName().startsWith("M");
                    }
                });

        assertEquals(2, filtered.size());
    }

    public void shouldTransformCollection() {
        // better to use the collection-specific version on Lists, Maps, Sets, etc.
        final Collection<String> transformed = Collections2.transform(people,
                new Function<Person, String>() {
                    public String apply(@Nullable Person input) {
                        return input != null ? input.getFirstName() : "";
                    }
                });

        assertEquals(3, transformed.size());
        assertTrue(transformed.contains("First"));
        assertTrue(transformed.contains("Mary"));
        assertTrue(transformed.contains("Michael"));
    }
}
