package leetcode_2020;

import java.util.ArrayList;
import java.util.List;

/*
* https://leetcode-cn.com/problems/combinations/
*
* 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。---不重复*/
public class code077_combine
{
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k)
    {
        if (k <= 0 || n <= 0)
            return res;
        List<Integer> list = new ArrayList<>();
        backpack(n, k, 1, list);
        return res;
    }

    public void backpack(int n, int k, int start, List<Integer> l)
    {
        if (k == l.size())
        {
            res.add(new ArrayList<>(l));
            return;
        }
        for (int i = start; i <= n; i++)
        {
            l.add(i);
            backpack(n, k, i + 1, l);
            l.remove(l.size() - 1);
        }
    }
}
