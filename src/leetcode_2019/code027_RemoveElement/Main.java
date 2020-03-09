package leetcode_2019.code027_RemoveElement;

public class Main {
	// 这种方法使用的是双指针法
	public static int removeElement(int[] nums, int val) {
		// j存放结果数组长度
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			// 如果原数组中存在相同元素时，直接通过i++跳过。
			// 存在不相同元素时
			if (nums[i] != val) {
				// 将不等于val元素的存入j数组中
				nums[j] = nums[i];
				// 结果数组+1
				j++;
			}
		}
		return j ;
		/*
		//i是结果数组的长度
		int i = 0;
		// k循环到数组结束
		for (int k = 0; k < nums.length; k++) {
			// 如果出现相同数字，
			if (nums[i] == val) {
				for (int j2 = i; j2 < nums.length - 1; j2++) {
					// 数组整体往前挪，即删除一个val。
					nums[j2] = nums[j2 + 1];
				}
			} else {
				// 目前的数组已经是更新后的【前i位无val】
				i++;
			}
		}
		return i;
		 */
	}

	public static void main(String[] args) {
		removeElement(new int[] { 3, 2, 2, 3 }, 3);
	}
}
