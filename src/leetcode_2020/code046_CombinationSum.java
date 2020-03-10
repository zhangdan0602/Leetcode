package leetcode_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Zd on 2020/2/18.
 */
public class code046_CombinationSum {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;
    public void findCombination(int residue, int start, Stack<Integer> pre){
        if (residue == 0){
            res.add(new ArrayList<>(pre));
            return;
        }
        for (int i = start; i < len && residue - candidates[i] >= 0; i++) {
            pre.add(candidates[i]);
            findCombination(residue - candidates[i], i, pre);
            pre.pop();
        }

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0)
            return res;
        Arrays.sort(candidates);
        this.len = len;
        this.candidates = candidates;
        findCombination(target, 0, new Stack<>());
        return res;
    }
}
