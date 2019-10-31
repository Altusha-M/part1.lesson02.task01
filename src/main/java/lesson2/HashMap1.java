package lesson2;

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
}

public class HashMap1 {
    private int size = 100;
    private int bucketSize = 10;
    private int bucketIndex;
    private int counter = 0;

    public int getSize() {
        return size;
    }

    public int size() { // tested
        return counter;
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
        counter++;
    }

    public void put(Object key, Object value) {
        Node newNode = new Node(key, value);
        try {
            bucketIndex = newNode.getHash() & (size - 1);
        } catch (NullPointerException e) {
            throw e;
        }
        boolean emptyBucketCondition = myMap[bucketIndex][0] == null;
        if (emptyBucketCondition) {
            myMap[bucketIndex][0] = newNode;
            counter++;
        } else {
            int i = 0;
            do {
                if (!myMap[bucketIndex][i].getKey().equals(key)) {
                    myMap[bucketIndex][i] = newNode;
                    counter++;
                }
                i++;
            } while (myMap[bucketIndex][i+1] != null);
        }
    }


    public void put(Node newNode) {
        try {
            bucketIndex = newNode.getHash() & (size - 1);
        } catch (NullPointerException e) {
            throw e;
        }
        boolean emptyBucketCondition = myMap[bucketIndex][0] == null;
        if (emptyBucketCondition) {
            myMap[bucketIndex][0] = newNode;
            counter++;
        } else {
            int i = 0;
            do {
                if (!myMap[bucketIndex][i].getKey().equals(newNode.getKey())) {
                    myMap[bucketIndex][i] = newNode;
                    counter++;
                }
                i++;
            } while (myMap[bucketIndex][i+1] != null);
        }
    }


    public Object get(Object key) {
        try {
            bucketIndex = key.hashCode() & (size - 1);
        } catch (NullPointerException e) {
            throw e;
        }
        boolean emptyBucketCondition = myMap[bucketIndex][0] == null;
        if (emptyBucketCondition) {
            return null;
        } else {
            int i = 0;
            do {
                if (myMap[bucketIndex][i].getKey().equals(key)) {
                    return myMap[bucketIndex][i].getKey();
                }
                i++;
            } while (myMap[bucketIndex][i+1] != null);
            return null;
        }
    }

    public void remove(Object key) {
        try {
            bucketIndex = key.hashCode() & (size - 1);
        } catch (NullPointerException e) {
            throw e;
        }
        boolean emptyBucketCondition = myMap[bucketIndex][0] == null;
        if (emptyBucketCondition) {
            throw new RuntimeException();
        } else {
            int i = 0;
            do {
                if (myMap[bucketIndex][i].getKey().equals(key)) {
                    myMap[bucketIndex][i] = null;
                    counter--;
                    return;
                }
                i++;
            } while (myMap[bucketIndex][i+1] != null);
            throw new RuntimeException();
        }
    }

    public void clear() {
        for (bucketIndex = 0; bucketIndex < size; bucketIndex++) {
            for(int i = 0; i < bucketSize; i++) {
                myMap[bucketIndex][i] = null;
                counter = 0;
            }
        }
    }

    public boolean containsKey(Object key) {
        try {
            bucketIndex = key.hashCode() & (size - 1);
        } catch (NullPointerException e) {
            throw e;
        }
        boolean emptyBucketCondition = myMap[bucketIndex][0] == null;
        if (emptyBucketCondition) {
            return false;
        } else {
            int i = 0;
            do {
                if (myMap[bucketIndex][i].getKey().equals(key)) {
                    return true;
                }
                i++;
            } while (myMap[bucketIndex][i+1] != null);
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
        myMap.remove(1);
        System.out.println(myMap.get(1));
        myMap.clear();
        System.out.println(myMap.get("12"));
    }
}
