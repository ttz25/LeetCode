package com.ttz;

/**
 * 作者： 周婷婷
 * 日期： 2021-06-03 22:17
 * 描述：
 **/
public class Question_633 {

    public boolean judgeSquareSum(int c) {

        int left = 0;
        int right = new Double(Math.sqrt(c)).intValue()+1;
        while (left >= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }

        }
        return  false;
    }

}