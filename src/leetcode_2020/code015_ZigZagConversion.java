package leetcode_2020;

import java.util.ArrayList;
import java.util.List;

public class code015_ZigZagConversion
{
    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
        {
            list.add(new StringBuilder());
        }
        int curRow = 0;
        //boolean goingDown = false;
        int goingDown = -1;
        for (char c: s.toCharArray())
        {
            list.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1)
                //goingDown = !goingDown;
                goingDown = - goingDown;
            //curRow += goingDown ? 1 : -1;
            curRow += goingDown;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list)
        {
            res.append(sb);
        }
        return res.toString();
    }
    public static void main(String args[]){
        System.out.println(convert("LEETCODEISHIRING", 3));
    }
}
