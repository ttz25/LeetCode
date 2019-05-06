package test;

import java.util.ArrayList;

public class Question_7 {
    /*
     *执行用时: 45 ms,内存消耗: 48.9 MB
     */
    public static int reverse1(int x) {
        int y = 0;
        ArrayList<Integer> list = new ArrayList<>();
        if(x%10 != 0){
            list.add(Integer.valueOf(x%10));
        }
        x=x/10;
        while(x != 0){
            list.add(Integer.valueOf(x%10));
            x=x/10;
        }
        double con = list.size()-1;
        for(int i = 0;i<list.size();i++,con--){
            y += list.get(i)*Math.pow(10,con);
            if(y == -Math.pow(2,31) || y==Math.pow(2,31)-1){
                return 0;
            }
        }

        return y;

    }
    /*
     *官方解答
     */
    public static int reverse2(int x) {
        int rev = 0;
        while(x != 0 ){
            int pop = x%10;
            x /= 10;
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop >7)) return 0;
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev*10 +pop;

        }
        return rev;
    }

    public static void main(String args[]){
        int num =1534236469;
        System.out.println(reverse2(num));
        System.out.print(-Math.pow(2,31)+"~"+(Math.pow(2,31)-1));
    }
}