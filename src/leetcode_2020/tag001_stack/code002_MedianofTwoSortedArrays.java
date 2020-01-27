package leetcode_2020.tag001_stack;

/**
 * Created by Zd on 2020/1/26.
 */
public class code002_MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int i =0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j])
                nums[k++] = nums1[i++];
            else
                nums[k++] = nums2[j++];
        }
        while(i < nums1.length)
            nums[k++] = nums1[i++];
        while(j < nums2.length)
            nums[k++] = nums2[j++];
        if(nums.length % 2 == 0)
            return (nums[nums.length/2] + nums[nums.length/2 - 1])/2.0;
        else
            return nums[nums.length/2];

        /*int m = nums1.length, n = nums2.length;
        if (m > n){
            int[] tmp = nums1; nums1 = nums2; nums2 = tmp;
            int t = m; m = n; n = t;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1)/2;
        while (iMin < iMax){
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j - 1] > nums1[i])
                iMin = i + 1;
            else if (i > iMin && nums1[i - 1] > nums2[j])
                iMax = i - 1;
            else {
                int maxLeft = 0;
                if(i == 0) maxLeft = nums2[j-1];
                else if(j == 0) maxLeft = nums1[i-1];
                else maxLeft = Math.max(nums1[i-1],nums2[j-1]);
                if ((m+n) % 2 == 1)
                    return maxLeft;

                int minRight = 0;
                if(i==m) minRight = nums2[j];
                else if(j==n) minRight = nums1[i];
                else minRight = Math.min(nums1[i],nums2[j]);
                if((m+n)% 2 == 0)
                    return (minRight+maxLeft)/2.0;
            }
        }
        return 0.0;*/
    }
    public static void main(String args[]){
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }
}

