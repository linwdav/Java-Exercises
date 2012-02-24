package setsAndHashMaps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Test the HashSet class.
 * @author David Lin
 */
public class TestHashSet {

  /**
   * JUnit test on the Stack class.
   */
  @Test
  public void testStackClass() {

    HashSet set = new HashSet();
    List<AbstractMap.SimpleEntry<String, Integer>> array =
        new ArrayList<AbstractMap.SimpleEntry<String, Integer>>();

    // Add two key-value pairs into set
    set.add("first", 1);
    set.add("second", 2);

    // Test for two key-value pairs
    array = set.getAll();
    assertEquals("There should be two items in the Set", 2, array.size());
    assertTrue("Set should contain the key 'first'", set.contains("first"));
    assertFalse("Set should not contain the key 'third'", set.contains("third"));

    // Test for Set property
    set.add("first", 100);
    array = set.getAll();
    assertEquals("There should be two items in the Set", 2, array.size());
    assertEquals("The key 'second' should have value 2", Integer.valueOf(2), set.get("second"));

    // Test remove function
    assertNull("Removing unmapped key should have returned null", set.remove("third"));
    assertEquals("Removing they key 'second' should have returned the value '2'",
        Integer.valueOf(2), set.remove("second"));
    array = set.getAll();
    assertEquals("There should be one item in the Set", 1, array.size());
  }

}