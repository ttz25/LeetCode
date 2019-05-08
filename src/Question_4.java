package src;

/**
 * 作者： 周婷婷
 * 日期： 2019-04-02 17:28
 * 描述：4. 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 *请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 **/
public class Question_4 {

    /**
     * 失败！
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //有一个为空，若nums1为空
        if((nums1 == null || nums1.length <1) &&(nums2!=null && nums2.length>0)){
            if(nums2.length%2 == 0){
                return (double) (nums2[nums2.length/2-1]+nums2[nums2.length/2])/2.0;
            }
            else{
                return (double) (nums2[nums2.length/2]);
            }
        }
        //有一个为空，若nums2为空
        if((nums2 == null || nums2.length <1) &&(nums1!=null && nums1.length>0)){
            if(nums1.length%2 == 0){
                return (double) (nums1[nums1.length/2-1]+nums1[nums1.length/2])/2.0;
            }
            else{
                return (double) (nums1[nums1.length/2]);
            }
        }

       /* if(nums1[0]>= nums2[nums2.length-1]){
            if((nums1.length+nums2.length)%2 == 0){
                int count = (nums1.length+nums2.length)/2 ;
                if(count > nums2.length-1){
                    return nums1
                }
            }
        }*/

       int left = 0,right = nums1.length-1;
       while(left<right-1){


       }
        return 0;

    }

    /**
     * 解答，递归法
     * 理解中位数的含义：将一个集合划分为两个长度相等的子集，其中一个子集中的元素总是大于另一个子集中的元素。
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    /**
     * 自己写一遍
     * @param A
     * @param B
     * @return
     */
    public double my_1(int[] A,int[] B) {
        int m = A.length;
        int n = B.length;
        if (m>n){
            int[] temp = A; A = B; B = temp;
            int tem  = m; m = n; n = tem;
        }
        int i ,j ;
        int imin = 0,imax = m , half = (m+n+1)/2;
        while (imin<=imax){
            i = (imin+imax)/2;
            j = half-i;
            //A[i] 太小，增大,[i+1,imax]
            if(i<imax && B[j-1] > A[i]){
                imin = i+1;
            }
            //A[i] 太大，减小,[imin,i-1]
            else if(i>imin && A[i-1] > B[j]){
                imax = i-1;
            }
            //临界情况
            else{
                int maxLeft = 0;
                if(i==0){
                    maxLeft = B[j-1];
                }
                else if(j == 0){
                    maxLeft = A[i-1];
                }
                else{
                    maxLeft = Math.max(A[i-1],B[j-1]);
                }
                if((m+n)%2 == 1){
                    return maxLeft;
                }

                int minRight = 0;
                if(i ==m){
                    minRight = B[j];
                }
                else if(j ==n){
                    minRight = A[i];
                }
                else{
                    minRight = Math.min(A[i],B[j]);
                }

                return (maxLeft+minRight)/2.0;
            }
        }
        return 0.0;
    }


}