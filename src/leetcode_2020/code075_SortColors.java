package leetcode_2020;

public class code075_SortColors
{
    // 计数排序
    public static void sortColors(int[] nums) {
        int[] numbers = new int[nums.length];
        int max = nums[0], min = nums[0];
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] > max){
                max = nums[i];
            }
            if (nums[i] < min){
                min = nums[i];
            }
        }
        int k = max - min + 1;
        int[] count = new int[k];
        for (int i = 0; i < nums.length; i++)
        {
            count[nums[i] - min] += 1;
        }
        for (int i = 1; i < count.length; i++)
        {
            count[i] = count[i] + count[i - 1];
        }
        for (int i = nums.length - 1; i >=0; i--){
            numbers[--count[nums[i] - min]] = nums[i];
        }
        for (int i = 0; i < numbers.length; i++)
        {
            System.out.println(numbers[i]);
        }
    }

    public static void sortColors1(int[] nums) {
        int curr = 0, po = 0, p2 = nums.length - 1;
        int temp = 0;
        while (curr <= p2){
            if (nums[curr] == 2){
                temp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = temp;
            }else if(nums[curr] == 0){
                temp = nums[po];
                nums[po++] = nums[curr];
                nums[curr++] = temp;
            }else
                curr++;
        }
        for (int i = 0; i < nums.length; i++)
        {
            System.out.println(nums[i]);
        }
    }
    public static void swap(int[] nums, int l, int r){
        int t = l;
        l = r;
        r = t;
    }
    public static void main(String[] args){
        sortColors1(new int[]{2,2,1,1,0,1});
    }
}
