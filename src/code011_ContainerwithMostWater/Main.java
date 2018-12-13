package code011_ContainerwithMostWater;

public class Main {
	public static int maxArea(int[] height) {
		int max = 0;
		//直接暴力，注意取值边界
		for (int i = height.length - 1; i > 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				//巧用Math.max()存储不断变化的最大值
				max = Math.max(max, (i - j) * (Math.min(height[j], height[i])));
			}
		}
		return max;
	}
	public static int maxArea1(int[] height) {
		//定义左右双指针
		int left=0,right=height.length-1,area=0,min=0;
		//注意限制条件 
		while(left>=0&&right<height.length&&left<right){
			//巧用 Math.min()和Math.max()函数;
			//得到最小高度
			min=Math.min(height[left], height[right]);
			//得到最大面积
			area=Math.max(area,(right-left)*min);
			//不论左右，保持较长高度不变,即较短指针向较长指针靠拢。左侧低：左侧指针+1；右侧低：右侧指针-1
			if (min==height[left]) {
				left++;
			}
			else {
				right--;
			}
		}
		return area;
	}

	public static void main(String[] args) {
		int height[] = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		maxArea(height);
		maxArea1(height);
	}
}
