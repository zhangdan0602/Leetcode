package leetcode_2019.code033_SearchinRotatedSortedArray;

public class Main {
	public static int search(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]== target) {
				return i;
			}
		}
		return -1;
	}

	public static int search1(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] <= nums[high]) {
				if (nums[mid] > target || nums[high] < target) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			if (nums[mid] >= nums[low]) {
				if (nums[low] > target || nums[mid] < target) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		search(new int[] { 0, 1, 2, 4, 5, 6, 7 }, 3);
	}
}
