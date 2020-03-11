package leetcode_2020;

public class code125_ValidPalindrome
{
    public static boolean isPalindrome(String s) {
        if (s.length() < 1)
            return true;
        int left = 0, right = s.length() - 1;
        while (left < right){
            if (!Character.isLetterOrDigit(s.charAt(left)))
                left++;
            else if (!Character.isLetterOrDigit(s.charAt(right)))
                right--;
            else {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                    return false;
                left++;
                right--;
            }
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(isPalindrome("a plan, 21nalp,a"));
    }
}
