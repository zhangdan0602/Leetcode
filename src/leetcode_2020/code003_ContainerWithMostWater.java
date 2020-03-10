package leetcode_2020;

/**
 * Created by Zd on 2020/1/27.
 */
public class code003_ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++){
            for (int j = i + 1; j < height.length; j++){
                if((j - i) * Math.min(height[i], height[j]) > max ){
                    max = (j - i) * Math.min(height[i], height[j]);
                }
            }
        }
        return max;
    }

    public static int maxArea1(int[] height){
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right){
//        for(int i = 0; i < height.length; i++){
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
    public static void main(String args[]){
        maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }
}
