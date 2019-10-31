package lesson2;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashMap1Test {
    HashMap1 myMap = new HashMap1();

    @Test
    public void size() {
        int i = 0;
        for (i = 0; i < 1000; i++) {
            myMap.put("nodeNumber" + i, "value");
        }
        assertEquals(myMap.size(), i);
    }

    @Test
    public void put() {
        String a = "1st key";
        myMap.put(a, 1);
        int hashInMap = myMap.getMyMap()[a.hashCode() & (myMap.getSize() - 1)][0].getKey().hashCode();
        assertEquals(hashInMap, a.hashCode());
    }

    @Test
    public void containsKey() {
        myMap.put("1", "1");
       // assertTrue(myMap.containsKey("1"));
    }

    @Test
    public void main() {
    }
}