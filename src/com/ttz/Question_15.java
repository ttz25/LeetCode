package com.ttz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 作者： 周婷婷
 * 日期： 2019-04-07 11:01
 * 描述：15. 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 **/
public class Question_15 {

    /**
     * 解答错误
     * @param nums
     * @return
     */
    public List<List<Integer>> my_1(int [] nums){
        List<List<Integer>> lists = new ArrayList<>();
        List<String> numbers = new ArrayList<>();

        List<Integer> list  ;
        for(int j = 0;j<nums.length-2;j++){
            for(int z = j+1;z<nums.length-1;z++){
                for(int n = z+1;n<nums.length;n++){
                    list = new ArrayList<>() ;
                    if(!(numbers.contains(nums[j]+""+nums[z]+""+nums[n]) || (numbers.contains(nums[j]+""+nums[n]+""+nums[z])
                            || numbers.contains(nums[z]+""+nums[j]+""+nums[n]) || (numbers.contains(nums[z]+""+nums[n]+""+nums[j]))
                            || numbers.contains(nums[n]+""+nums[j]+""+nums[z]) || (numbers.contains(nums[n]+""+nums[z]+""+nums[j]))))){
                        if(nums[j]+nums[z]+nums[n] == 0 ) {
                            list.add(nums[j]);
                            list.add(nums[z]);
                            list.add(nums[n]);
                            if (list.size() != 0) lists.add(list);
                            numbers.add(nums[j]+""+nums[z]+""+nums[n]);
                        }
                    }
                }
            }
        }
        return lists;
    }

    /**
     * 解答，先排序，用i遍历数组，判断下一个是否相等来去重，指针l,r，来遍历数组
     * @param nums
     * @return
     */
    public List<List<Integer>> answer_1(int [] nums){
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-2;i++){
            //去重
            if(i ==0 || (i>0 && nums[i] != nums[i-1])){
                int l = i+1,r = nums.length-1,sum = 0 - nums[i];
                while(l<r){
                    if(sum == nums[l]+nums[r]){
                        lists.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        //跳过重复的数字
                        while(l<r && nums[l] == nums[l+1]) l++;
                        while(l<r && nums[r] == nums[r-1]) r--;
                        l++;
                        r--;
                    }
                    else if(sum > nums[l]+nums[r]){
                        while(l<r && nums[l] == nums[l+1]) l++;
                        l++;
                    }
                    else{
                        while(l<r && nums[r] == nums[r-1]) r--;
                        r--;
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Question_15 test = new Question_15();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println("[-1,0,1,2,-1,-4]-->"+test.answer_1(nums));
    }
}