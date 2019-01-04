package code046_Permutations;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import sun.launcher.resources.launcher;

/**
 * @author:zd
 * @date:2019年1月3日下午9:35:31
 * @parameter
 * @return
 */
public class Main {
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> rs = new ArrayList<List<Integer>>();
		//需要声明新方法，传入start和end
		perm(rs, nums, 0, nums.length - 1);
		return rs;
	}

	public static void perm(List<List<Integer>> list, int[] nums, int start, int end) {
		//存放每一排列的集合
		List<Integer> internal = new ArrayList<>();
		//start增到可以将排列存入list
		if (start == end) {
			for (int i = 0; i < end; i++) {
				internal.add(nums[i]);
			}
			list.add(internal);
		} else {
			//for循环数组长度，内部会再递归一次【for循环长度-1】，依次内部类推递归【for循环次数减少至1，这时会添加到list】。
			//下一次循环时使用的nums是上一次循环的结果。
			for (int i = start; i <= end; i++) {
				//交换位置
				swap(nums, start, i);
				//内部交换时使用nums_tmp
				int nums_temp[] = nums.clone();
				//递归调用，tmp传参数，start+1是为了添加到list。
				perm(list, nums_temp, start + 1, end);
			}
		}
	}
	/*
	 nums[123]
	 s=0
	 i=0
	 tmp=[123]
	 
	 	s=1
	 	i=1
	 	tmp=[123]
	 	
	 		s=2[add to list]
	 		[123]
	 		
	 	s=1
	 	i=2
	 	tmp=[132]
	 		s=2[add to list]
	 		[123,132]
	 		
	 		
	 nums[123]
	 s=0
	 i=1
	 tmp=[213]
	 
	 	s=1
	 	i=1
	 	tmp=[213]
	 	
	 		s=2[add to list]
	 		[123,132,213]
	 		
	 	s=1
	 	i=2
	 	tmp=[231]
	 		s=2[add to list]
	 		[123,132,213,231]
	 		
	 		
	 nums[213]
	 s=0
	 i=2
	 tmp=[312]
	 
	 	s=1
	 	i=1
	 	tmp=[312]
	 		
	 		s=2[add to list]
	 		[123,132,213,231,312]
	 		
	 	s=1
	 	i=2
	 	tmp=[321]
	 		s=2[add to list]
	 		[123,132,213,231,312,321]
	 		
	 */

	private static void swap(int[] nums, int start, int i) {
		int tmp = nums[start];
		nums[start] = nums[i];
		nums[i] = tmp;

	}

	public static void main(String[] args) {
		permute(new int[] { 1, 2, 3 });
	}
}
