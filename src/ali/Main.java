package ali;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Main
{
    public static String NumToCard(int x){
        if (x == 10)
            return "A";
        else
            return String.valueOf(x);
    }
    public static void Print(ArrayList<String> list){
        int count = 0;
        String[] nodes = null;
        if (list.size() == 0){
            System.out.println("null");
        }else {
            for (String s:list)
            {
                nodes = s.split(",");
                count += (1 + (nodes.length - 4)) * (nodes.length - 4) / 2;
            }
            System.out.println(count);
            for (String s:list)
            {
                nodes = s.split(",");
                for (int i = 5; i <= nodes.length; i++)
                {
                    for (int j = 0; i - j > 4 ; j++)
                    {
                        System.out.print(nodes[j].trim());
                        for (int x = j + 1; x < i; x++)
                        {
                            System.out.print("," + nodes[x]);
                        }
                        System.out.println();
                    }

                }
            }
        }
    }


    public static void main(String[] args){
        String[] cards = {"6", "2", "3","7", "4", "5", "8", "8", "9","A"};
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < cards.length; i++)
        {
            if (cards[i] == "A"){
                set.add(1);
            }else {
                set.add(Integer.valueOf(cards[i]));
            }
        }

        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0, begin = 0;
        Integer[] numbers = new Integer[1];
        numbers = set.toArray(numbers);

        for (Integer i:set)
        {
            if (count == 0){
                begin = i;
                count++;
                stringBuilder.append(NumToCard(begin));
            }else if(i == begin + count){
                stringBuilder.append("," + NumToCard(i));
                count++;
            }else {

                if (count > 5){
                    list.add(stringBuilder.toString());
                }
                begin = i;
                stringBuilder.replace(0, stringBuilder.length(), NumToCard(i) +"");
                count = 1;
            }
        }
        if (count > 5)
            list.add(stringBuilder.toString());

        System.out.println(list.size() * 3);

    }

}
