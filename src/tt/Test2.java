package tt;

import java.util.HashMap;
import java.util.Map;

public class Test2 {

    public static void main(String[] c) {
        Map<Integer, String> m = new HashMap<>();
        m.put(1, "a");
        m.put(2, "b");
        m.put(3, "c");
        m.put(4, "d");
        m.put(11, "a");
        m.put(31, "c");
        m.put(41, "d");
        m.put(30, "d");
        m.put(32, "d");
        m.put(321, "zxc");
        System.out.println(m);
//		
//		A a  = new A();
//		a.x();
    }

}


