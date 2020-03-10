package leetcode_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code119_PascalsTriangleII
{

    public static List<Integer> generate(int rowIndex) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i <= rowIndex; i++)
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
        return result.get(rowIndex);
    }
    public static List<Integer> generate1(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex+1);
        long index = 1;
        for (int i = 0; i <= rowIndex ; i++)
        {
            res.add((int)index);
            index = index * (rowIndex - i) / (i + 1);
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(generate1(3));
    }
}
