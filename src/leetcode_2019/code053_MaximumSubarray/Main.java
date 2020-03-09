package leetcode_2019.code053_MaximumSubarray;

/**
 * @author:zd
 * @date:2019年1月5日下午4:10:34
 * @parameter
 * @return
 */
public class Main {
	public static int maxSubArray(int[] nums) {
		//	中间结果初始化 0
		int midRs = 0;
		//	结果初始化 nums[0]
		int rs = nums[0];
		for (int i = 0; i < nums.length; i++) {
			// 每次比较加这一个数的大小，小则取这一个值
			midRs = Math.max(midRs + nums[i], nums[i]);
			// 如果midRs出现比上次值小时，由rs保存上次的值
			rs = Math.max(rs, midRs);
		}
		return rs;
	}

	public static void main(String[] args) {

	}
}
