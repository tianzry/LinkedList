package Binary;

/**
 * Created by tianz on 2017/6/1 0001.
 */
public class BinaryQuest {
    /**
     * 求一个二进制数当中1的个数，时间复杂度为O(n)
     * @param n
     * @return
     */
    public static int countOneNum(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    /**
     * 计算二进制数当中1的个数，时间复杂度为O(n)
     * @param n
     * @return
     */
    public static int countOneNumLowEffect(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    /**
     * 计算一个数与2^n的乘积
     * @param m
     * @param n
     * @return
     */
    public static int powerN(int m, int n) {
        for (int i = 0; i < n; i++) {
            m = m<<1;
        }
        return m;
    }

    public static boolean isPower(int n) {
        return  (n&(n-1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println("判断二进制数里头含1的个数：");
        System.out.println(countOneNum(1));
        System.out.println(countOneNum(11));
        System.out.println(countOneNumLowEffect(1));
        System.out.println(countOneNumLowEffect(11));
        
        System.out.println("乘以一个2的n次方："+powerN(5,2));
        System.out.println("判断是否为2的n次方数："+isPower(4));
    }
}
