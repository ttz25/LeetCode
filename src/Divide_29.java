package test;

/**
 * 作者： 周婷婷
 * 日期： 2019-04-18 13:57
 * 描述：29. 两数相除,给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符
 **/
public class Divide_29 {

    /**结果：超时！！！,加减运算，效率太低
     * 我的解答：利用加减法，除数加/减多上个除数，
     * @param dividend
     * @param divisor
     * @return
     */
    public int my_1(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        int res = 0;
        if(dividend > 0 && divisor>0) {
            while (dividend >= divisor) {
                dividend -= divisor;
                res++;
            }
        }
        if(dividend < 0 && divisor < 0){
            while (dividend <= divisor) {
                dividend -= divisor;
                res++;
            }
        }
        if(dividend > 0 && divisor < 0){
            while (dividend >= divisor && dividend >= Math.abs(divisor)) {
                dividend += divisor;
                res--;
            }
        }
        if(dividend < 0 && divisor > 0){
            while (dividend <= divisor && Math.abs(dividend) >= divisor) {
                dividend += divisor;
                res--;
            }
        }
        return res;
    }

    /**成功！
     * 我的解答:加减运算效率低，改成移位运算，右移一位，相当于除2
     *          1.右移n位，dividend/2^n,
     *          2.找到dividend/2^n >= divisor的n，就找到了（2^n）*divisor不大于dividend
     *          3.减去（2^n）*divisor，divisor左移n位
     *          4.以此类推
     * @param dividend
     * @param divisor
     * @return
     */
    public int my_2(int dividend, int divisor) {
        if(divisor == 0){
            return 0;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int res = 0;
        //位异或运算，判断符号是否相异（从高位开始比较，如果相同则为0，不相同则为1）
        boolean negative = (dividend^divisor) < 0;
        long t = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        //int32位,除去符号位，31位
        for(int i = 31;i>=0;i--){
            if((t>>i) >= d){
                res += 1<<i;
                t -= d<<i;
            }
        }
        return negative? -res : res;
    }

    public static void main(String[] args) {
        Divide_29 test = new Divide_29();
       System.out.println(test.my_2(-100,-6));
    }
}
