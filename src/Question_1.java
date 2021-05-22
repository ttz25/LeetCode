package src;
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
        int nums[] = {2,7,11,15};
        int result[] = s.twoSum(nums,9);
        System.out.println("["+result[0]+","+result[1]+"]");
    }
}