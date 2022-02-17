package com.ttz;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 作者： 周婷婷
 * 日期： 2022-02-16 21:22
 * 描述：
 **/
public class Question_3 {

    /**
     * 自己的想法，两次遍历，复杂度高
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int max = s.length() == 0? 0 : 1;
        for(int i = 0;i<chars.length - 1;i++){
            set.clear();
            set.add(chars[i]);
            for (int j = i +1 ; j<chars.length ; j++) {
                if (set.contains(chars[j])) {
                    break;
                } else {
                    set.add(chars[j]);
                    if (j-i+1 > max) {
                        max = j-i+1;
                    }
                }
            }
        }
        return max;
    }

    /**
     * 官方解答，滑动窗口，遇到重复的字符，应该从被重复的字符后一个位置开始，重新计算
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int max = 0, left = 0;
        for (int i = 0;i<chars.length;i++) {
            if (map.containsKey(chars[i])) {
                left = Math.max(left, map.get(chars[i])+1);
            }
            map.put(chars[i], i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}