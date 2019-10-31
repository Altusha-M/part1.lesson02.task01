package lesson2;

class Globals {
    public static int counter = 0;
}

class Node {
    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public int getHash() {
        return hash;
    }

    private Object key;
    private Object value;
    private int hash;

    Node(Object key, Object value) {

        this.key = key;
        if (key == null) {
            throw new IllegalArgumentException();
        }
        this.value = value;
        if (value == null) {
            throw new IllegalArgumentException();
        }
        hash = key.hashCode();
    }

    public void remove(Object key) {
        this.key = null;
        Globals.counter--;
    }
}

public class HashMap1 {
    private int size = 100;
    private int bucketSize = 10;
    private int bucketIndex;

    public int getSize() {
        return size;
    }

    public int size() { // tested
        return Globals.counter;
    }

    public Node[][] getMyMap() {
        return myMap;
    }

    public Node[][] myMap = new Node[size][bucketSize];

    public HashMap1() {
    }


    public HashMap1(Object key, Object value) {
        Node newNode = new Node(key, value);
        this.put(newNode);
    }

    public void put(Object key, Object value) {
        Node newNode = new Node(key, value);
        try {
            bucketIndex = newNode.getHash() & (size - 1);
        } catch (NullPointerException e) {
            throw e;
        }
        boolean emptyBucketCondition = myMap[bucketIndex][0].getKey() == null;
        if (emptyBucketCondition) {
            myMap[bucketIndex][0] = newNode;
        } else {
            int i = 0;
            while (myMap[bucketIndex][i] != null) {
                if (myMap[bucketIndex][i].getKey().equals(key)) {
                    myMap[bucketIndex][i] = newNode;
                }
                i++;
            }
        }
    }


    public void put(Node newNode) {
        bucketIndex = newNode.getKey().hashCode() & (size - 1);
        if ((myMap[bucketIndex][0] == null) ||
                !(myMap[bucketIndex][0].getKey().equals(newNode.getKey())) ||
                !(myMap[bucketIndex][0].getKey().hashCode() == newNode.getKey().hashCode())
        ) {
            myMap[bucketIndex][0] = newNode;
            Globals.counter++;
        } else {
            myMap[bucketIndex][0] = newNode;
        }
    }


    public Object get(Object key) {
        try {
            bucketIndex = key.hashCode() & (size - 1);
        } catch (NullPointerException e) {
            throw e;
        }
        boolean emptyBucketCondition = myMap[bucketIndex][0].getKey() == null;
        if (emptyBucketCondition) {
            return null;
        } else {
            int i = 0;
            while (myMap[bucketIndex][i] != null) {
                if (myMap[bucketIndex][i].getKey().equals(key)) {
                    return myMap[bucketIndex][i].getValue();
                }
                i++;
            }
            return null;
        }
    }

    public void remove(Object key) {
        int hash = key.hashCode();
        int bucketIndex = hash & (size - 1);
    }

    public void clear() {
        myMap = new Node[size][bucketSize];
    }

    public boolean containsKey(Object key) {
        try {
            bucketIndex = key.hashCode() & (size - 1);
        } catch (NullPointerException e) {
            throw e;
        }
        boolean emptyBucketCondition = myMap[bucketIndex][0].getKey() == null;
        if (emptyBucketCondition) {
            return false;
        } else {
            int i = 0;
            while (myMap[bucketIndex][i] != null) {
                if (myMap[bucketIndex][i].getKey().equals(key)) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        HashMap1 myMap = new HashMap1();
        myMap.put("10", "10");
        myMap.put("11", "10");
        myMap.put("12", "10");
        myMap.put(1, "10");
        myMap.put(2, "10");
        System.out.println(myMap.containsKey("1"));
        System.out.println(myMap.size());
        System.out.println(myMap.get("12"));
    }
}
