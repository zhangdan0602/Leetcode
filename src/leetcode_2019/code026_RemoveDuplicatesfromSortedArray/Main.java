package leetcode_2019.code026_RemoveDuplicatesfromSortedArray;

public class Main {
	public static int removeDuplicates(int[] nums) {
		// i是结果数组的长度
		int i = 1;
		// k循环到数组结束
		for (int k = 1; k < nums.length; k++) {
			// 如果出现相同数字，为了节省变量将j改为i-1
			if (nums[i] == nums[i - 1]) {
				for (int j2 = i; j2 < nums.length - 1; j2++) {
					// 数组整体往前挪，即删除前一个相同的。
					nums[j2] = nums[j2 + 1];
				}
			} else {
				// 目前的数组已经是更新后的【前i位无重复项】，如果数字不相同，则结果数组长度+1，进行下次循环
				i++;
			}
		}
		return i;
/*
		// 这种方法使用的是双链表法
		// j存放结果数组长度
		int j = 0;
		for (int i = 1; i < nums.length; i++) {
			// 如果原数组中存在相同元素时，直接通过i++跳过。
			// 存在不相同元素时
			if (nums[i] != nums[j]) {
				j++;
				// 将不相同元素的存入j数组中
				nums[j] = nums[i];
			}
		}
		return j + 1;
*/
	}

	public static void main(String[] args) {
		removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 });
	}
}
