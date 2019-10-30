package lesson2;

import java.util.HashMap;

public class Hell {
    public static void main(String[] args) {
        class Class {
            String s = "11";
        }
        Class c = new Class();
        HashMap<Object, Object> n = new HashMap<Object, Object>();
        n.put(1,1.5d);
        n.put("1","255");
        n.put(c,c);
        System.out.println(n.get("s"));
        System.out.println(n.get(1));
        System.out.println(n.get(c));
    }
}