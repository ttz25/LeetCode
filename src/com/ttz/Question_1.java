package com.ttz;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 */
class Question_1 {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for(int i = 0;i<len-1;i++){
            for(int j =i+1;j<len;j++){
                if((nums[i]+nums[j]) == target){
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("no two sum solution");
    }
    public static void main(String[] args){
        Question_1 s = new Question_1();
        int nums[] = {11,15,2,7};
        int result[] = s.twoSum2(nums,9);
        System.out.println("["+result[0]+","+result[1]+"]");
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get((target - nums[i])), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two sum solution");
    }
}