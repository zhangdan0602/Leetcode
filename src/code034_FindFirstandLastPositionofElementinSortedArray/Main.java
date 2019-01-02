package code034_FindFirstandLastPositionofElementinSortedArray;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static int[] searchRange(int[] nums, int target) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				// 直接查询，满足条件的就存入list
				list.add(i);
			}
		}
		// 都不满足条件时，直接返回两个-1
		if (list.size() == 0) {
			return new int[] { -1, -1 };
		}
		// 满足条件时，只需要返回开始位置和结束位置，即链表的头元素和尾元素
		return new int[] { list.get(0), list.get(list.size() - 1) };
	}

	public static int[] search1(int[] nums, int target) {
		// 采用二分法，
		int low = 0, high = nums.length - 1;
		// 用于存放结果
		int rs[] = new int[2];
		while (low <= high) {
			int mid = (low + high) / 2;
			// mid和target相等
			if (nums[mid] == target) {
				// 循环查找开始位置的下标
				while (low < mid) {
					if (nums[low] == target) {
						// 相同时，存入开始位置的下标
						rs[0] = low;
						// 结束
						break;
					} else {
						// 不相同时，low增加
						low++;
					}
				}
				// 循环查找结束位置的下标
				while (mid < high) {
					if (nums[high] == target) {
						// 相同时，存入结束位置的下标
						rs[1] = high;
						// 结束
						break;
					} else {
						// 不相同时，high减少
						high--;
					}
				}
				// 返回开始位置和结束位置
				return new int[] { low, high };
			} else if (nums[mid] >= target) {
				// mid大，high提前
				high = mid - 1;
			} else {
				// mid小，low提高
				low = mid + 1;
			}
		}
		// 都不满足条件时，直接返回两个-1
		return new int[] { -1, -1 };

	}

	public static void main(String[] args) {
		int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
		searchRange(nums, 8);
	}
}
