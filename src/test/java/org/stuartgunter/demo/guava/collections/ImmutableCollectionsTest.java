package org.stuartgunter.demo.guava.collections;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

/**
 * User: gunters
 * Created: 16/12/2011 09:28
 */
@Test
public class ImmutableCollectionsTest {

    public void shouldProveUnmodifiableListIsAView() {
        final List<String> baseList = Lists.newArrayList("A", "B", "C");
        final List<String> unmodifiableList = Collections.unmodifiableList(baseList);

        assertEquals(3, baseList.size());
        assertEquals(3, unmodifiableList.size());

        baseList.add("D");

        assertEquals(4, baseList.size());
        assertEquals(4, unmodifiableList.size());
    }

    public void shouldProveImmutableListIsADifferentList() {
        final List<String> baseList = Lists.newArrayList("A", "B", "C");
        final List<String> unmodifiableList = ImmutableList.copyOf(baseList);

        assertEquals(3, baseList.size());
        assertEquals(3, unmodifiableList.size());

        baseList.add("D");

        assertEquals(4, baseList.size());
        assertEquals(3, unmodifiableList.size());
    }

    public void shouldBuildImmutableList() {
        final List<String> immutableList = ImmutableList.of("A", "B", "C", "D");

        assertEquals(4, immutableList.size());
    }

    public void shouldBuildImmutableListWithBuilder() {
        final List<String> list1 = Lists.newArrayList("A", "B");
        final List<String> list2 = Lists.newArrayList("C", "D");
        final List<String> list3 = Lists.newArrayList("E", "F");

        final List<String> immutableList = ImmutableList.<String>builder()
                .addAll(list1)
                .addAll(list2)
                .addAll(list3)
                .add("X", "Y", "Z")
                .build();

        assertEquals(9, immutableList.size());
    }

    public void shouldBuildImmutableMultimapWithBuilder() {
        Multimap<String, Integer> immutableMultimap = ImmutableMultimap.<String, Integer>builder()
                .put("A", 1)
                .putAll("B", 1, 2, 3, 4)
                .putAll("C", 10, 15, 20)
                .build();

        assertEquals(1, immutableMultimap.get("A").size());
        assertEquals(4, immutableMultimap.get("B").size());
        assertEquals(3, immutableMultimap.get("C").size());
    }
}
