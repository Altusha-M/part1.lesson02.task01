package lesson2;

import java.util.HashMap;

public class Hell {
    public static void main(String[] args) {
       // HashMap1 myMap = new HashMap1("10", "10");
        HashMap<Object, Object> map = new HashMap<>();
        map.put(null,1);
        /*myMap.put("11", "10");
        myMap.put("12", "10");
        myMap.put(1, "10");
        myMap.put(2, "10");
        */System.out.println(null == null);
        System.out.println(map.get(1));
    }
}