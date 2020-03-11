package leetcode_2020;

import java.util.Map;

public class code121_BestTimetoBuyandSellStock
{
    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length ; i++)
        {
            for (int j = i - 1; j >= 0; j--)
            {
                if ((prices[i] - prices[j]) > max)
                    max = prices[i] - prices[j];
            }
        }
        return max;
    }
    public static int maxPro(int[] prices){
        if (prices.length < 1)
            return 0;
        int buy = -prices[0], sell = 0;
        for (int i = 1; i < prices.length; i++)
        {
            buy = Math.max(buy, -prices[i]);
            sell = Math.max(sell, buy + prices[i]);
        }
        return sell;
    }
    public static void main(String[] args){
        System.out.println(maxPro(new int[]{7, 1, 6, 4, 3, 1}));
    }
}
