package lesson2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashMap1Test {
    HashMap1 myMap = new HashMap1();

    @Test
    public void size() {
        int i = 0;
        for (i = 0; i < 50; i++) {
            myMap.put("nodeNumber" + i, "value");
        }
        assertEquals(i, myMap.size());
    }

    @Test
    public void put() {
        myMap.clear();
        String a = "1st key";
        myMap.put(a, 1);
        int hashInMap = myMap.getMyMap()[a.hashCode() & (myMap.getSize() - 1)][0].getKey().hashCode();
        assertEquals(hashInMap, a.hashCode());
        try {
            myMap.put(null);
            Assert.fail("Expected NullPointerException");
        }catch (NullPointerException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void containsKey() {
        myMap.clear();
        myMap.put("1", "1");
        assertTrue(myMap.containsKey("1"));
        try {
            myMap.containsKey(null);
            Assert.fail("Expected NullPointerException");
        }catch (NullPointerException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void main() {
    }

    @Test
    public void get() {
        Object o = "q";
        myMap.put(o, 2);
        assertTrue(myMap.get(o).equals(o));
        try {
            myMap.get(null);
            Assert.fail("Expected NullPointerException");
        }catch (NullPointerException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void remove() {
        myMap.put("1","3");
        myMap.put(1,"3");
        assertTrue(myMap.containsKey("1"));
        myMap.remove("1");
        assertTrue(!myMap.containsKey("1"));
        try {
            myMap.remove(null);
            Assert.fail("Expected NullPointerException");
        }catch (NullPointerException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void clear() {
        myMap.put("2","3");
        myMap.put("4","3");
        myMap.put("5","3");
        myMap.put("6","3");
        myMap.put("27","3");
        myMap.clear();
        assertEquals(0, myMap.size());
    }

}