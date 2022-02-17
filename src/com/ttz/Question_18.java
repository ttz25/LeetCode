package com.ttz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 作者： 周婷婷
 * 日期： 2019-04-17 8:41
 * 描述：18. 四数之和
 **/
public class Question_18 {

    /**
     * 我的解答：先排序，再遍历,结合之前“三数之和”的方法，添加一层遍历，将“四数”-->"三数"
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> my_1(int[] nums, int target) {
        Arrays.sort(nums);
        int left, right, sum;
        List<List<Integer>> res = new ArrayList<>();

        //添加一层遍历
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                //将“四数”-->"三数"
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || j > 1 && nums[j] != nums[j - 1]) {

                        left = j + 1;
                        right = nums.length - 1;
                        sum = target - nums[i] - nums[j];
                        while (left < right) {
                            if (sum == nums[left] + nums[right]) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                                while (left < right && nums[left] == nums[left + 1]) left++;
                                while (left < right && nums[right] == nums[right - 1]) right--;
                                left++;
                                right--;
                            } else if (sum > nums[left] + nums[right]) {
                                while (left < right && nums[left] == nums[left + 1]) left++;
                                left++;
                            } else {
                                while (left < right && nums[right] == nums[right - 1]) right--;
                                right--;
                            }
                        }
                    }
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Question_18 test = new Question_18();
        int[] nums = {0,0,0,0};
        System.out.println(test.my_1(nums,0));
    }

}
