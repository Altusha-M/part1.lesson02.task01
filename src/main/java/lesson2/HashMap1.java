package lesson2;

class Globals{
    public static int counter = 0;
}

public class HashMap1 {
    private int size = 16;
    class Node {
        Object key;
        Object value;
        int hash;
        Node(Object key, Object value){
            this.key = key;
            this.value = value;
            Globals.counter++;
            hash = key.hashCode() & (size - 1);
        }

        public void remove(Object key) {
            this.key = null;
            Globals.counter--;
        }
    }

    public Node[][] myMap = new Node[size][100];

    public HashMap1(Object key, Object value) {
        Node newNode = new Node(key, value);
        put(newNode);
    }

    public void put(Object key, Object value){
        Node newNode = new Node(key, value);
        if (    (myMap[newNode.hash][0] == null) ||
                (myMap[newNode.hash][0].key.equals(newNode.key))
            )
            myMap[newNode.hash][0] = newNode;
    }

    public void put(Node newNode){
        if (    (myMap[newNode.hash][0] == null) ||
                (myMap[newNode.hash][0].key.equals(newNode.key))
            )
            myMap[newNode.hash][0] = newNode;
    }

   /*public Object get(Object key){
        int getHash = key.hashCode() & size;
        if (myMap[getHash][1] == null) {
            return myMap[getHash][0];
        } else {
            return key;
        }
    }*/

    public boolean containsKey(Object key){
        if (myMap[key.hashCode() & (size-1)][0] == null){
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
        myMap.put("11", "10");
        myMap.put("12", "10");
        myMap.put(1, "10");
        myMap.put(2, "10");
        System.out.println(myMap.containsKey("10"));
        System.out.println(myMap.size());
    }
}
