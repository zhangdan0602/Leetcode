package leetcode_2019.code018_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> rs = new ArrayList<List<Integer>>();
		// 边界条件
		if (nums == null || nums.length < 4) {
			return rs;
		}
		// 排序
		Arrays.sort(nums);
		// 用来存储唯一数组
		HashSet<ArrayList<Integer>> hSet = new HashSet<ArrayList<Integer>>();
		//类似于3数之和，多一个循环；而且注意边界条件
		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {
				//分治件
				int left = j + 1;
				int right = nums.length - 1;
				while (left < right) {
					//注意：求和一定在这里，
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					//满足
					if (sum == target) {
						//定义新list
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[left]);
						list.add(nums[right]);
						//保存唯一数组
						if (!hSet.contains(list)) {
							hSet.add(list);
							rs.add(list);
						}
						//继续寻找
						left++;
						right--;
					} else if (sum < target) {
						//和太小，往前走
						left++;
					} else {
						//和太大，后退
						right--;
					}
				}
			}
		}
		//输出结果
		for (int i = 0; i < rs.size(); i++) {
			for (int j = 0; j < rs.get(i).size(); j++) {
				System.out.print(rs.get(i).get(j) + ";");
			}
			System.out.println();
		}
		return rs;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		fourSum(nums, target);
	}
}
