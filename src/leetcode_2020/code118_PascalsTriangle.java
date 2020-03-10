package leetcode_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code118_PascalsTriangle
{

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows < 1)
            return result;
        for (int i = 0; i < numRows; i++)
        {
            List<Integer> list = Arrays.asList(new Integer[i+1]);
            list.set(0, 1);
            list.set(i, 1);
            for (int j = 1; j < i; j++)
            {
                list.set(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            result.add(list);
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(generate(4));
    }
}
