package com.ttz;

/**
 * 作者： 周婷婷
 * 日期： 2021-07-03 20:39
 * 描述： 680. 验证回文字符串 Ⅱ  给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 **/
public class Question_680 {
    public static boolean validPalindrome(String s) {

        boolean flag = true;
        int i = 0, j = s.length()-1;
        char[] array = s.toCharArray();
        while (i < j) {
            if (array[i] == array[j]) {
                i ++;
                j --;
            } else if (flag && i+1 <j && array[i+1] == array[j]){
               i+=2;
               j--;
               flag = false;
            } else if (flag && i <j-1 && array[i] == array[j-1]){
                i++;
                j-=2;
                flag = false;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        Question_680 question_680 = new Question_680();

        boolean b = question_680.validPalindrome2(s);
        System.out.println(b);
    }

    public boolean validPalindrome2(String s) {
        int i = 0;
        int j = s.length()-1;
        for (;i<j;i++,j--){
            if ( s.charAt(i) != s.charAt(j)) {
                return this.sub(s, i+1, j) || this.sub(s, i, j-1);
            }
        }
        return true;
    }

    private boolean sub(String s, int i, int j) {
        while (i < j) {
            if ( s.charAt(i++) != s.charAt(j--)) {
               return false;
            }
        }
        return true;
    }


}