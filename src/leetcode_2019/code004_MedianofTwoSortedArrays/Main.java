package leetcode_2019.code004_MedianofTwoSortedArrays;

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
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] {};
		int[] nums2 = new int[] { 2, 3 };
		findMedianSortedArrays(nums1, nums2);
		// 1.nums1 和 nums2 都加入数组，再排序
		// 2.nums1 和 nums2 不断加入数组，直接求结果
	}
}
