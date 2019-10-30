package mypackage;
import java.util.*;

public class hello {

    public static void main(String[] args) {
        Set<Parent> a = new HashSet<Parent>();
        Child c = new Child();
        Child d = new Child();
        Child w = new Child();
        Child e = new Child();
        Child q = new Child();

        a.add(c);
        a.add(d);
        a.add(w);
        a.add(e);
        a.add(q);

        for (Parent p: a) {
            p.goUp();
        }
        HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();

    }
}
