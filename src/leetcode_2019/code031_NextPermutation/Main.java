package leetcode_2019.code031_NextPermutation;


public class Main {
	public static void nextPermutation(int[] nums) {
		/*
		 * 1.判断按照字典序有木有下一个，如果完全降序就没有下一个 
		 * 2.如何判断有木有下一个呢？只要存在a[i-1] < a[i]的升序结构，就有，
		 * 而且我们应该从右往左找，一旦找到，因为这样才是真正下一个 
		 * 3.当发现a[i-1] < a[i]的结构时，从在[i,∞]中找到最接近a[i-1]并且又大于a[i-1]的数字，由于降序，从右往左遍历即可得到k
		 * 4.然后交换a[i-1]与a[k]，然后对[i, ∞]排序即可， 排序只需要首尾不停交换即可，因为已经是降序
		 * 上面说的很抽象，还是需要拿一些例子思考才行，比如[0,5,4,3,2,1]，下一个是[1,0,2,3,4,5]
		 */
		int i = nums.length - 2;
		// 从右往左找到第一个逆序数
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		// 第一个逆序元素与大于这个逆序数的值交换
		if (i >= 0) {
			int j = nums.length - 1;
			while (j >= 0 && nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		// 即使没找到第一个逆序数【nums已降序】，将数组逆序排序【升序】
		// 交换之后，需要将交换后的第一个逆序元素之后的元素进行升序排序【因为原先已经是降序】
		reverse(nums, i + 1);
	}

	// 将降序数组反转为升序数组的方法1，left++；right--；
	private static void reverse(int[] nums, int start) {
		// 将降序数组反转为升序数组的方法，left++，mid=sum／2，start和end不确定
		// private static void reverse3(int[] nums, int start,int end) : int i = start, j = end;
		int i = start, j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			j--;
			i++;
		}
	}
	// 将降序数组反转为升序数组的方法2，left++，mid=sum／2
	private static void reverse1(int[] nums, int start) {
		// 将降序数组反转为升序数组的方法，left++，mid=sum／2，start和end不确定
		// private static void reverse4(int[] nums, int start,int end) : int sum = start + end;
		int sum = start + nums.length -1 ;
		int mid = sum / 2;
		// start <= mid【if：sum=2】
		for (; start <= mid; start++) {
			int tmp = nums[start];
			nums[start] = nums[sum - start];
			nums[sum - start] = tmp;
		}
	}
	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		nextPermutation(new int[] { 0, 5, 4, 3, 2, 1 });
	}
}
