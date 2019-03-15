/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * 思路：利用hash表的原理
 */
public class Test55 {
    private int[] hashTable = new int[256];

    public void Insert(char ch) {
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return '#';
    }
}
