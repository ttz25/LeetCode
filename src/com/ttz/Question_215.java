package com.ttz;

import java.util.Arrays;

/**
 * 作者： 周婷婷
 * 日期： 2021-07-05 19:46
 * 描述：
 **/
public class Question_215 {
    public static int findKthLargest(int[] nums, int k) {
        for (int i = 0; i <k; i++) {

            for (int j = i+1;j<nums.length;j++) {
                if (nums[i] < nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    System.out.println(nums[i]);
                }
            }
        }

        return nums[k-1];
    }

    public static void main(String[] args) {
        int[] a = {3,2,1,5,6,4};

        Question_215.findKthLargest(a, 2);
    }

    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}