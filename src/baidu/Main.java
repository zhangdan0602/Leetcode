package baidu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static int getCount(List<Integer> list, int n)
    {
        int count = 0;
        while (list.size() > 0)
        {
            Collections.sort(list);
            if (list.get(list.size() - 1) < n)
            {
                break;
            }
            list.remove(list.size() - 1);
            for (int i = 0; i < list.size(); i++)
            {
                list.set(i, list.get(i) + 1);
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            list.add(sc.nextInt());
        }
        int count = getCount(list, n);
        System.out.println(count);
    }
}
