package leetcode_2019.code001_TwoSum;

import java.util.HashMap;
import java.util.Map;

public class Main {
	/*
	public static int[] twoSum(int[] nums, int target) {
		//定义一个存放2个数的数组，存储结果并返回
		int[] rs=new int[]{0,0};
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i]+nums[j]==target) {
					rs[0]=i;
					rs[1]=j;
					return rs;
				}
			}
		}
		return rs;
	}
	 */
	/*
	public static int[] twoSum(int[] nums, int target) {
		for(int i=0;i<nums.length;i++)
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i]+nums[j]==target) {
					//直接return 一个new的新数组
					return new int[]{i,j};
				}
			}
		//主动抛出异常
		throw new IllegalArgumentException("no such two nums");
	}
	*/
	/*
	//两遍哈希表
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map=new HashMap<>();
		//第一遍哈希表：将给定的数存进map中
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int rs=target-nums[i];
			//map查询时间为O(1)
			if(map.containsKey(rs)&&map.get(rs)!=i){
				return new int[]{i,map.get(rs)};
			}
		}
		throw new IllegalArgumentException("no such two nums");
	}
	*/
	//一遍哈希表
	
	/**
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map=new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int rs=target-nums[i];
			if (map.containsKey(rs)) {
				//与两遍哈希表输出顺序相反
				return new int[]{map.get(rs),i};
			}
			//不需要提前存储，边判断边存储
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("no such two nums");
	}
	public static void main(String[] args) {
		int[] nums=new int[]{2,7,11,15};
		int target = 9;
		twoSum(nums, target);
		
	}
}
