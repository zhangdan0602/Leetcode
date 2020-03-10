package leetcode_2020;

import java.util.ArrayList;
import java.util.List;

public class code022_GenerateParentheses
{
    public void dfs(List<String> list, int left, int right, String rs, int n){

        if (left == n && right == n){
            list.add(rs);
            return;
        }
        if (left < n){
            dfs(list, left + 1, right, rs + "(", n);
        }
        if (left > right && right < n){
            dfs(list, left, right + 1, rs + ")", n);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(list, 0, 0, "", n);
        return list;
    }
    public static void main(String args[]){
        System.out.println();
    }
}
