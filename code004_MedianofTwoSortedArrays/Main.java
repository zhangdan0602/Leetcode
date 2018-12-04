package code004_MedianofTwoSortedArrays;

public class Main {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums = new int[nums1.length + nums2.length];
		int i = 0, j = 0, k = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				nums[k++] = nums1[i++];
			} else {
				nums[k++] = nums2[j++];
			}
		}
		while (i < nums1.length) {
			nums[k++] = nums1[i++];
		}
		while (j < nums2.length) {
			nums[k++] = nums2[j++];
		}
		if (nums.length % 2 != 0) {
			return nums[nums.length / 2] / 1.0;
		}
		return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
		
		/*
		 public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i; // j= (m + n + 1) / 2 - i
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect 同时满足B[j-1] ≤ A[i]以及 A[i-1] ≤ B[j]
                // 求maxLeft
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { 
                      return maxLeft; 
               }
                // 求minRight 
                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
}
		 * */
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] {};
		int[] nums2 = new int[] { 2, 3 };
		findMedianSortedArrays(nums1, nums2);
		// 1.nums1 和 nums2 都加入数组，再排序
		// 2.nums1 和 nums2 不断加入数组，直接求结果
	}
}
