package collectionsFramework;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public class Demo {

    public static void main(String[] args) {
        Test t1 = new Test("sumit", 25);
        Test t2 = new Test("sumit", 25);

        Set<Test> set = new HashSet<>();
        System.out.println("val1 "+set.add(t1));
        System.out.println("val2 "+set.add(t2));
        

        Consumer<Test> consume = s -> System.out.println(s.toString());
        set.forEach(t -> consume.accept(t));
        
        Set<String> tset = new TreeSet<>();

    }

}

class Test {
    private String name;
    private int age;

    public Test(String name, int age) {
        System.out.println(this);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int hashCode() {
//		public static int hashCode(Object a[]) {
//        if (a == null)
//            return 0;
//
//        int result = 1;
//
//        for (Object element : a)
//            result = 31 * result + (element == null ? 0 : element.hashCode());
//
//        return result;
//    }
        return Objects.hash(age, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Test other = (Test) obj;
        return age == other.age && Objects.equals(name, other.name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
