package org.stuartgunter.demo.guava.strings;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

/**
 * User: gunters
 * Created: 05/12/2011 08:43
 */
@Test
public class JoinerTest {

    public void shouldJoinList() {
        final List<String> strings = Lists.newArrayList("first", "second", "third", null, "fifth");

        assertEquals("first|second|third|empty|fifth", Joiner.on("|").useForNull("empty").join(strings));
        assertEquals("first|second|third|fifth", Joiner.on("|").skipNulls().join(strings));
    }

    public void shouldJoinMap() {
        final Map<String, String> params = ImmutableMap.of("key1", "value1", "key2", "value2");

        assertEquals("key1=value1&key2=value2", Joiner.on("&").withKeyValueSeparator("=").join(params));
    }
}
