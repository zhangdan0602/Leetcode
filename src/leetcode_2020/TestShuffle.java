package leetcode_2020;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class TestShuffle {

    private static Random random = new Random();

    public static void swap(int[] nums, int m, int n){
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
    public static void shuffle(int[] nums){
        int length = nums.length;
        for (int i = length; i > 0; i--)
        {
            int rand = random.nextInt(i);
            swap(nums, rand, i - 1);
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5};
        shuffle(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
