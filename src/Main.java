import com.example.java8.interfac.FooInterImpl;

public class Main {
    public static void main(String[] args) {
        FooInterImpl fooInter = new FooInterImpl("hwiseo");
        fooInter.printName();
        fooInter.printNameUpperCase();
    }
}