package code016_3SumClosest;

import java.util.Arrays;

public class Main {
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int min=Integer.MAX_VALUE;
		for (int i = 0; i < nums.length-2; i++) {
			int left=i+1;
			int right=nums.length-1;
			while(left<right){
				int sum=nums[i]+nums[left]+nums[right];
				//类似于三数之和为0  三数之和大于目标值，向左移动
				if (sum>target) {
					right--;
				}else if(sum<target){
					//三数之和小于目标值，向右移动
					left++;
				}else{
					//三数之和等于目标值，直接返回
					return target;
				}
				//不断查看与target的最小差，越小时返回sum。
				min=Math.abs(sum-target)-Math.abs(min-target)<0?sum:min;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int nums[] = new int[] { -1, 2, 1, -4 };
		int target = 1;
		threeSumClosest(nums, target);
	}
}
