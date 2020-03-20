package ali;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main1
{
    static Set<String> list = new TreeSet<>();
    public static String[] permutation(String s) {
        if (s == null || s.length() == 0)
            return new String[]{};

        char[] str = s.toCharArray();
        Arrays.sort(str);

        permutationHelper(str, 0);

        String[] res = new String[list.size()];
        int i = 0;
        for (String string:list)
        {
            res[i++] = string;
        }
        return res;
    }

    private static void permutationHelper(char[] s, int begin)
    {
        if (begin == s.length){
            list.add(String.valueOf(s));
            return;
        }

        for (int i = begin; i < s.length; i++)
        {
            if (i != begin && (s[i] == s[begin] || s[i] == s[i - 1]))
                continue;

            char temp = s[i];
            s[i] = s[begin];
            s[begin] = temp;

            permutationHelper(s, begin + 1);

            temp = s[i];
            s[i] = s[begin];
            s[begin] = temp;
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int k = 0; k < num; k++)
        {
            String input = scanner.nextLine();
            stringBuilder.append(input);
        }

        String s = stringBuilder.toString();
        String[] res = permutation(s);
        int max = 0;
        for (int k = 0; k < res.length; k++)
        {
            int[] dp = new int[res[k].length() + 1];
            int answer = 0;
            for (int i = 0; i < res[k].length(); i++)
            {
                dp[i] = 1;
                for (int j = 0; j < i; j++)
                {
                    if (res[0].charAt(j) <= res[0].charAt(i) && i - j == 1)
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                answer = Math.max(answer, dp[i]);
            }
            if (max < answer){
                max = answer;
            }
        }
        System.out.println(max);
    }
}
