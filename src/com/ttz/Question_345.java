package com.ttz;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 作者： 周婷婷
 * 日期： 2021-07-01 22:02
 * 描述：345. 反转字符串中的元音字母
 **/
public class Question_345 {
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length()-1;
        char[] chars = s.toCharArray();
        while (i<j) {
            char a = chars[i];
            char b = chars[j];
            if (!vowels.contains(a)) {
                i ++;
            }
            else if (!vowels.contains(b)) {
                j--;
            } else {
                chars[i] = b;
                chars[j] = a;
                i++;
                j--;
            }

        }

        return String.valueOf(chars);

    }

    public static void main(String[] args) {
        Question_345 question_345 = new Question_345();
        System.out.println(question_345.reverseVowels("leetcode"));
    }


    /**
     * 网上答题
     */


    public String reverseVowels2(String s) {
        if (s == null) return null;
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }

}