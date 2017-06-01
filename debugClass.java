/**
 * Created by tianz on 2017/5/25 0025.
 */
public class debugClass {
    public static final int i = 0;

    public static void test(String in) {
        in += "he";
        System.out.println(in);
    }
    public static void main(String[] args) {
        Integer a1 = 127;
        Integer a2 = 127;
        System.out.println(a1 == a2);
        Integer a3 = 128;
        Integer a4 = 128;
        System.out.println(a3 == a4);

        Integer b1 = new Integer(1);
        Integer b2 = new Integer(1);
        int c1 = 1;
        System.out.println(c1 == a1);
        System.out.println(b1==b2);
        String in = "Hell";
        test(in);
        System.out.println(in);
        
        Integer d1 = 1;
        Integer d2 = d1;
        d2 = 3;
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s1==s2);
        
        
    }
}
