package _1TDDDemo;

import java.util.Arrays;

/**
 * @author chenyue
 * @create 2019-01-13 23:14
 */
public class PrimUtil {

    //质数（prime number）又称素数，有无限个。
    //一个大于1的自然数，除了1和它自身外，不能整除其他自然数的数叫做质数；否则称为合数。
    //返回所有小于给定值max的所有素数组成的数组
/*    public static int[] getPrimes(int max) {
        if (max < 2) {
            return new int[]{};
        } else {
            int[] newArray = new int[max];
            int size = 0, j = 0;
            //从2开始累加到max
            for (int i = 2; i < max; i++) {
                //从2开始累加到i --> max中的
                //i / 2 + 1 -> 检验素数只要判断自己一般范围内的约数个数。
                // 很容易理解，如果一半范围内有一个能整除的数字，那么必定有一个数字在i / 2 + 1~ i内也是它的约数
                for (j = 2; j < i / 2 + 1; j++) {
                    if (i % j == 0) {
                        break;
                    }
                }
                if (j == i / 2 + 1) {
                    newArray[size++] = i;
                }
            }
            newArray = Arrays.copyOf(newArray, size);
            return newArray;
        }
    }*/

    //重构一上代码
    //1.选择合适参数命名
    //2.将判断逻辑提取为方法
    public static int[] getPrimes(int max) {
        if (max < 2) {
            return new int[]{};
        }
        //先重命名
        int[] primes = new int[max/2+1];
        int length = 0;
        //从2开始累加到max
        for (int num = 2; num <= max; num++) {
            if (isPrimes(num)) {
                //如果是素数,直接添加
                primes[length++] = num;
            }
        }
        primes = Arrays.copyOf(primes, length);
        return primes;
    }

    private static boolean isPrimes(int num) {
        for (int i = 2; i < num / 2 + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
