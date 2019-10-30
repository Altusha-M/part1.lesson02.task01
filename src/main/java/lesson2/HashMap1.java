package lesson2;

class Globals{
    public static int counter = 0;
}

public class HashMap1 {
    class Node {
        Object key;
        Object value;
        int hash;

        @Override
        public int hashCode() {
            int h1 = key.hashCode();
            return h1 & size;
        }

        Node(Object key, Object value){
            this.key = key;
            this.value = value;
            Globals.counter++;
        }

        public void remove(Object key) {
            this.key = null;
            Globals.counter--;
        }
    }

    private int size = 16;
    public Object[][] myMap = new Object[size][10];

    public HashMap1(Object key, Object value) {
        Node newNode = new Node(key, value);
        put(newNode);
    }

    public void put(Object key, Object value){
        Node newNode = new Node(key, value);
        myMap[newNode.hashCode()-1][0] = newNode;
    }

    public void put(Node newNode){
        myMap[newNode.hashCode()-1][0] = newNode;
    }

   /*public Object get(Object key){
        int getHash = key.hashCode() & size;
        if (myMap[getHash-1][1] == null) {
            return myMap[getHash-1][0];
        } else {
            return key;
        }
    }*/

    public boolean containsKey(Object key){
        if (myMap[key.hashCode() & -1][0] == null){
            return false;
        } else {
            return true;
        }
    }

    public int size(){
        return Globals.counter;
    }

    public static void main(String[] args) {
        HashMap1 myMap = new HashMap1("10", "10");
        System.out.println(myMap.containsKey("10"));
    }
}
