package leetcode_2020;

public class code154_MinNumberInRotatedArray
{
    /*
    * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
    * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
    * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。*/
    public static int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0){
            return 0;
        }
        int left = 0, right = numbers.length - 1, mid = left;
        while (numbers[left] >= numbers[right]){
            if (right - left == 1){
                mid = right;
                break;
            }
            mid = (left + right) / 2;
            if (numbers[left] == numbers[mid] && numbers[mid] == numbers[right])
                return MinInOrder(numbers, left, right);
            if (numbers[mid] >= numbers[left]){
                left = mid;
            }else if (numbers[mid] <= numbers[right])
                right = mid;

        }
        return numbers[mid];
    }

    public static int MinInOrder(int[] numbers, int left, int right)
    {
        int result = numbers[left];
        for (int i = left + 1; i <= right; i++)
        {
            if (result > numbers[i])
                result = numbers[i];
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(minArray(new int[]{1,1,1,0,1}));
        System.out.println(minArray(new int[]{3,4,0,1,2}));
        System.out.println(minArray(new int[]{2,3,4,1,2}));

    }
}
