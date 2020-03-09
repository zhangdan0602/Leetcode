package leetcode_2019.code047_PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:zd
 * @date:2019年1月4日上午11:02:33
 * @parameter
 * @return
 */
public class Main {
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> rs = new ArrayList<List<Integer>>();
		// 忽略重复元素：注意进行排序
		Arrays.sort(nums);
		// 需要声明新方法，传入start和end
		perm(rs, nums, 0, nums.length - 1);
		return rs;
	}

	public static void perm(List<List<Integer>> list, int[] nums, int start, int end) {
		// 存放每一排列的集合
		List<Integer> internal = new ArrayList<>();
		// start增到可以将排列存入list
		if (start == end) {
			for (int i = 0; i <= end; i++) {
				internal.add(nums[i]);
			}
			// 使用忽略数组重复元素去重
			list.add(internal);
			/*
			 * //确保不存在重复元素；方法2直接忽略数组重复元素时则不需要这句 if (!list.contains(internal)) {
			 * list.add(internal); }
			 */
		} else {

			/*
			 * //使用list去重
			 * //for循环数组长度，内部会再递归一次【for循环长度-1】，依次内部类推递归【for循环次数减少至1，这时会添加到list】。
			 * //下一次循环时使用的nums是上一次循环的结果。 for (int i = start; i <= end; i++) {
			 * //交换位置 swap(nums, start, i); //内部交换时使用nums_tmp int nums_temp[] =
			 * nums.clone(); //递归调用，tmp传参数，start+1是为了添加到list。 perm(list,
			 * nums_temp, start + 1, end); }
			 */

			int i = start;
			while (i <= end) {
				// 判断重复元素
				int tmp = nums[i];
				int j = i;
				// 一直忽略到重复元素截止为止
				while (j < nums.length && nums[j] == tmp) {
					j++;
				}
				// 继续调用上述swap和perm递归
				swap(nums, start, i);
				int nums_temp[] = nums.clone();
				perm(list, nums_temp, start + 1, end);
				// 只是需要将i变为重复元素截止
				i = j;
			}

		}
	}

	private static void swap(int[] nums, int start, int i) {
		int tmp = nums[start];
		nums[start] = nums[i];
		nums[i] = tmp;
	}

	public static void main(String[] args) {
		permute(new int[] { 1, 2, 3 });
	}
}
