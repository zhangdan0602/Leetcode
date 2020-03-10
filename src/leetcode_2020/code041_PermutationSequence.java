package leetcode_2020;

/**
 * Created by Zd on 2020/2/11.
 */
public class code041_PermutationSequence {
    public static String getPermutation(int n, int k) {
        int nums[] = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        for (int i = 1; i < k; i++) {
            generatePermutation(nums);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < nums.length; j++) {
            stringBuilder.append(nums[j]);
        }
        return stringBuilder.toString();
    }
    public static int[] generatePermutation(int nums[]){
        int i = nums.length - 1;
        for (; i > 0; i--) {
            if (i - 1 >= 0 && nums[i] > nums[i - 1]) {
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]){
                        swap(nums, j, i - 1);
                        reverse(nums, i);
                        break;
                    }
                }
                break;
            }
        }
        if (i == 0){
            reverse(nums, i);
        }
        return nums;
    }
    public static void reverse(int nums[], int i){
        int start = i, end = nums.length - 1;
        while (start < end){
            swap(nums, start, end);
            start++;
            end--;
        }

    }
    public static void swap(int nums[], int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String args[]){
        System.out.println(getPermutation(4,9));
    }

}
