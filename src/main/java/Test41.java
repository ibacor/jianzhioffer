import java.math.BigInteger;
import java.util.ArrayList;

public class Test41 {
    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
     * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     *
     * 思路：从两端往内走
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(array == null || array.length < 2)
            return result;

        int p1 = 0;
        int p2 = array.length - 1;
        long curSum;

        while(p1 < p2){
            curSum = array[p1] + array[p2];
            if(curSum == sum){
                result.add(array[p1]);
                result.add(array[p2]);
                p1++;
                p2--;
            }else if(curSum < sum){
                p1++;
            }else{
                p2--;
            }
        }

        int size = result.size();
        if(size == 0)
            return result;

        ArrayList<Integer> res = new ArrayList<Integer>(2);
        res.add(result.get(0));
        res.add(result.get(1));
        BigInteger product = BigInteger.valueOf(result.get(0)).
                multiply(BigInteger.valueOf(result.get(1)));
        for (int i = 2; i < result.size(); i=i+2) {
            BigInteger temp = BigInteger.valueOf(result.get(i)).
                    multiply(BigInteger.valueOf(result.get(i+1)));
            if(product.compareTo(temp) > 0){
                res.clear();
                res.add(result.get(i));
                res.add(result.get(i+1));
            }
        }
        return res;
    }

    /**
     * 输入一个正数s，打印出所有和为s 的连续正数序列（至少两个数）。
     *
     * 思路：与上面类似，两个指针，连续和小于时右边指针往右走，大于时左边指针往右走，相等时右边往右走
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(sum < 3)
            return result;

        int small = 1;
        int big = 2;
        int mid = (1+sum)/2;
        int curSum = small + big;

        while(small < mid){
            if(curSum == sum){
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                result.add(list);
            }

            while(curSum > sum && small < mid){
                curSum -= small;
                small++;

                if(curSum == sum){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    for (int i = small; i <= big; i++) {
                        list.add(i);
                    }
                    result.add(list);
                }
            }

            big++;
            curSum += big;
        }

        return result;
    }
}
