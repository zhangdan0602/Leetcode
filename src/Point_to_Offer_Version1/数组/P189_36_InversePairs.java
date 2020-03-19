package Point_to_Offer_Version1.数组;

public class P189_36_InversePairs
{
    /*
    *在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
    * 输入一个数组，求出这个数组中的逆序对的总数。
    */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] copy = new int[nums.length];
        return findReversePairs(nums, copy, 0, nums.length - 1);
    }

    public int findReversePairs(int[] nums, int[] copy, int l, int r)
    {
        if (l == r)
            return 0;
        int mid = (l + r) / 2;
        int left = findReversePairs(nums, copy, l, mid);
        int right = findReversePairs(nums, copy,mid + 1, r);

        int count = merge(nums, copy, l, mid, r);

        return left + right + count;
    }

    public int merge(int[] nums, int[] copy, int l, int mid, int r)
    {
        for (int i = l; i <= r; i++)
        {
            copy[i] = nums[i];
        }
        int i = l, j = mid + 1, count = 0;
        for (int k = l; k <= r; k++)
        {
            if (i > mid){
                nums[k] = copy[j++];
            }else if(j > r){
                nums[k] = copy[i++];
                count += (r - mid);
            }else if (copy[i] <= copy[j]){
                nums[k] = copy[i++];
                count += (j - mid - 1);
            }else {
                nums[k] = copy[j++];
            }
        }
        return count;
    }


    public static void main(String[] args){
        P189_36_InversePairs p189_36_inversePairs = new P189_36_InversePairs();
        System.out.println(p189_36_inversePairs.reversePairs(new int[]{7,5,6,4}));
    }
}
