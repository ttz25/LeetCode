package com.ttz;

/**
 * 作者： 周婷婷
 * 日期： 2019-03-27 8:57
 * 描述：14.最长公共前缀
 *      编写一个函数来查找字符串数组中的最长公共前缀。
 *      如果不存在公共前缀，返回空字符串 ""。
 **/
public class Question_14 {

    public String longestCommonPrefix(String[] strs){
        if(strs.length == 0){
            return "";
        }
        StringBuilder  res = new StringBuilder();
        for(int i = 0;i<strs[0].length();i++){
            for(int j= 1;j<strs.length;j++){
                if(!(i<strs[j].length() && (strs[j].charAt(i) == strs[0].charAt(i)))){
                    return res.toString();
                }
            }
            res.append(strs[0].charAt(i));
        }
        return res.toString();
    }

    /**
     *分治法
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        Question_14 obj = new Question_14();
        obj.longestCommonPrefix2(strs);
    }
}