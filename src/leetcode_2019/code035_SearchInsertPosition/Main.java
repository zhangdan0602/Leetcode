package leetcode_2019.code035_SearchInsertPosition;

public class Main {
	public static int searchInsert(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				// 相等时直接返回位置即可
				return i;
			}
		}
		// 都没有相等值的情况
		for (int i = 0; i < nums.length; i++) {
			if (target < nums[i]) {
				// target小于最小值
				if (i == 0) {
					return 0;
				}
				// target小于下一个值
				return i;
			}
			// target大于最大值
			if (target > nums[nums.length - 1]) {
				return nums.length;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		searchInsert(new int[] { 1, 3, 5, 6 }, 5);
	}
}
