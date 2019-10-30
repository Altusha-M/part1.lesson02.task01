package mypackage;

public class Child extends Parent {
    @Override
    public void goUp() {
        System.out.println("MyPackage.Child goes up");
    }

    public static void doSmth(){
        System.out.println("Doing smth");
    }

    public int sum(int i, int j){
        return i + j;
    }
    public int add5(int i){
        return i + 5;
    }
}
