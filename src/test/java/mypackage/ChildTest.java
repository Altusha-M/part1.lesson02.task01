package mypackage;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChildTest {

    @Test
    public void sum() {
        int a = new Child().sum(2,1);
        assertEquals(a, 3);
    }
}