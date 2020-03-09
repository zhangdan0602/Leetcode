package leetcode_2019.code015_3Sum;
import java.util.*;
public class Main {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> rs=new ArrayList<List<Integer>>();
		//边界条件
		if (nums==null||nums.length<3) {
			return rs;
		}
		//将数组排序
		Arrays.sort(nums);
		//hashset 存储唯一值
		HashSet<ArrayList<Integer>> hSet=new HashSet<ArrayList<Integer>>();
		//排序后确定一个值
		for (int i = 0; i < nums.length-2; i++) {
			//确定一个值后，左右两侧向中间靠拢
			int low=i+1;
			int high=nums.length-1;
			while(low<high){
				int sum=nums[i]+nums[low]+nums[high];
				if (sum==0) {
					//直接定义list初始化
					ArrayList<Integer> tuple=new ArrayList(Arrays.asList(nums[i],nums[low],nums[high]));
					//不重复
					if (!hSet.contains(tuple)) {
						hSet.add(tuple);
						//结果中才添加
						rs.add(tuple);
					}
					//继续靠拢
					low++;
					high--;
				}else if (sum<0) {
					//和太小 往右移动
					low++;
				}else {
					//和太大，往左移
					high--;
				}
			}
		}
		/*
		 暴力，超时间
		for (int i = 0; i < nums.length-2; i++) {
			for (int j = i+1; j < nums.length-1; j++) {
				for (int k = j+1; k < nums.length; k++) {
					if (nums[i]+nums[j]+nums[k]==0) {
						//System.out.println(nums[i]+";"+nums[j]+";"+nums[k]);
						List<Integer> tuple=new ArrayList(Arrays.asList(nums[i],nums[j],nums[k]));
						Collections.sort(tuple);
						if (!rs.contains(tuple)) {
							rs.add(tuple);
						}
					}
				}
			}
		}*/
		for (int i = 0; i < rs.size(); i++) {
			for (int j = 0; j < rs.get(i).size(); j++) {
				System.out.print(rs.get(i).get(j)+";");
			}
			System.out.println();
		}
		return rs;
	}

	public static void main(String[] args) {
		int[] nums=new int[]{-1, 0, 1, 2, -1, -4};
		threeSum(nums);
	}
}
