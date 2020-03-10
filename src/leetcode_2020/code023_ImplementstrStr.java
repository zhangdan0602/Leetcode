package leetcode_2020;

public class code023_ImplementstrStr
{
    public static int strStr(String haystack, String needle) {
        int index = haystack.indexOf(needle);
        return index;
    }
    public static void main(String args[]){
        System.out.println(strStr("hello", "aab"));
    }
}
