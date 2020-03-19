package meituan;

import java.util.*;

public class Main
{


    public static void main(String[] args){
        /*1-
        Scanner scanner;
        scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int input1[] = new int[num];
        int input2[] = new int[num];
        for (int i = 0; i < input1.length; i++)
        {
            input1[i] = scanner.nextInt();
        }
        for (int i = 0; i < input2.length; i++)
        {
            input2[i] = scanner.nextInt();
        }

        Arrays.sort(input1);
        Arrays.sort(input2);
        int res1 = input1[input1.length - 1] + input1[input1.length - 2] + input1[input1.length - 3];
        int res2 = input2[input2.length - 1] + input2[input2.length - 2] + input2[input2.length - 3];
        System.out.println(Math.max(res1, res2));
        */

        //2-输出仅包含一个正整数，即删除一个数字之后的最长上升子串长度。
        /*
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int input1[] = new int[num];
        for (int i = 0; i < input1.length; i++)
        {
            input1[i] = scanner.nextInt();
        }
        Random random = new Random();
        int r = random.nextInt(input1.length);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input1.length; i++)
        {
            if (i != r){
                list.add(input1[i]);
            }
        }
        int input2[] = new int[num - 1];
        for (int i = 0; i < input2.length; i++)
        {
            input2[i] = list.get(i);
        }
        int[] dp = new int[input2.length + 1];
        int answer = 0;
        for (int i = 0; i < input2.length; i++)
        {
            dp[i] =1;
            for (int j = 0; j < i; j++)
            {
                if (input2[j] < input2[i] && i - j == 1)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
        */



        /*5-某个序列的最长不下降子序列的定义为将这个序列去除最少的数，使得剩下的每一个数都大于等于他自身前面的数。比如，1,0,0,1,1的最长不下降子序列为0,0,1,1，其中去除了第一个1，剩下的数0,0,1,1后面的数都大于等于前面的数。

        现在有一个特殊的序列，这个序列中所有的数都是0或者1。你需要按照题目所给的顺序完成两种任务：

        1.将某段区间的0变为1,1变为0

        2.询问整段序列的最长不下降子序列长度。

        每一个操作进行后都会对序列造成改变，这意味着整个序列会不停的发生变化。
        */
        /*
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int question = scanner.nextInt();
        String number = scanner.next();
        int input1[] = new int[length];
        for (int i = 0; i < input1.length; i++)
        {
            input1[i] = number.charAt(i) - 48;
        }
        for (int i = 0; i < input1.length; i++)
        {
            System.out.println(input1[i]);
        }
        while (question != 0){
            String type = scanner.nextLine();
            if (type.length() == 0){
                continue;
            }
            if (type.length() == 1){
                int[] dp = new int[input1.length + 1];
                int answer = 0;
                for (int i = 0; i < input1.length; i++)
                {
                    dp[i] = 1;
                    for (int j = 0; j < i; j++)
                    {
                        if (input1[j] <= input1[i] && i - j == 1)
                            dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                    answer = Math.max(answer, dp[i]);
                }
                System.out.println(answer);
            }
            else{
                String[] ts = type.split(" ");
                int left = Integer.valueOf(ts[1]);
                int right = Integer.valueOf(ts[2]);
                for (int i = left - 1; i < right; i++)
                {
                    input1[i] = input1[i] == 0 ? 1 : 0;
                }
            }
            question--;
        }
        */
        /*
        * 现在一共有n个任务可以完成。对于每个任务，都有k个子任务可以做。并且第 i 个子任务需要花费的时间是 ti 。我们可以认为一个子任务需要的时间只和这个子任务是第几个子任务有关，而不和这是属于哪个任务有关。也就是说n个任务的第 i 个子任务需要的时间都是一样的。

        每个任务都只可以完成一次，同时每个子任务也只能完成一次，任何任务都不能重复完成。

        每当你完成一个子任务你会获得p分，而当你完成一个任务的k个子任务后，你会获得额外的q分，也就是说你会获得pk+q分。

        现在你一共有m的时间，你需要求出最大的得分。*/



    }

}
