package org.stuartgunter.demo.guava.strings;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * User: gunters
 * Created: 05/12/2011 08:53
 */
@Test
public class SplitterTest {

    public void shouldSplitIntoList() {
        final String input = "first , second , third , fourth ,,, seventh";

        assertEquals(
                Lists.newArrayList("first ", " second ", " third ", " fourth ", "", "", " seventh"),
                Lists.newArrayList(Splitter.on(",").split(input)));

        assertEquals(
                Lists.newArrayList("first ", " second ", " third ", " fourth ", " seventh"),
                Lists.newArrayList(Splitter.on(",").omitEmptyStrings().split(input)));

        assertEquals(
                Lists.newArrayList("first", "second", "third", "fourth", "", "", "seventh"),
                Lists.newArrayList(Splitter.on(",").trimResults().split(input)));
    }

    public void shouldSplitIntoMap() {
        final String input = "key1=value1&key2=value2";

        assertEquals(
                ImmutableMap.of("key1", "value1", "key2", "value2"),
                Splitter.on("&").withKeyValueSeparator("=").split(input));
    }
}
