package _1TDDDemo;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author chenyue
 * @create 2019-01-13 23:08
 */
public class PrimeUtilTest {
    @Test
    public void testGetPrimesForEmptyresult(){
        int[] expected = {};
        Assert.assertArrayEquals(expected, PrimUtil.getPrimes(1));
        Assert.assertArrayEquals(expected, PrimUtil.getPrimes(0));
        Assert.assertArrayEquals(expected, PrimUtil.getPrimes(-1));
    }

    @Test
    public void testGetPrimes(){
        for (int prime : PrimUtil.getPrimes(7)) {
            System.out.println(prime);
        }
        Assert.assertArrayEquals(new int[]{2}, PrimUtil.getPrimes(2));
        Assert.assertArrayEquals(new int[]{2,3,5,7}, PrimUtil.getPrimes(9));
        Assert.assertArrayEquals(new int[]{2,3,5,7,11,13,17}, PrimUtil.getPrimes(17));
        Assert.assertArrayEquals(new int[]{2,3,5,7,11,13,17,19,23,29}, PrimUtil.getPrimes(30));
    }
}
