/**
 * 作者： 周婷婷
 * 日期： 2021-05-22 16:32
 * 描述： 167. 两数之和 II - 输入有序数组
 **/
public class Question_167 {

    public static void main(String[] args) {
        Question_167 q = new Question_167();
        int[] numbers = {3,24,50,79,88,150,345};
        int target = 200;
        int[] ints = q.twoSum2(numbers, target);
        System.out.println(ints[0]);
        System.out.println(ints[1]);

    }

    /**
     * 我的：使用二分法，因为已经排序了，
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {

        int sum = 0;
        int end = numbers.length-1;
        for (int start=0;start<numbers.length-1;start++){
            for ( ; end>start; end--){
                sum=numbers[end]+numbers[start];
                if (sum == target){
                    return new int[]{start+1, end+1};
                }else if (sum<target){
                    break;
                }

            }
        }
        return null;

    }

    /**
     * 网上解题
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {

        if (numbers == null) return null;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;

    }

}