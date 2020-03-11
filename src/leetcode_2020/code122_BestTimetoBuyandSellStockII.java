package leetcode_2020;

public class code122_BestTimetoBuyandSellStockII
{
    public static int maxProfit(int[] prices){
        if (prices.length < 1)
            return 0;
        int buy = -prices[0], sell = 0;
        for (int i = 1; i < prices.length; i++)
        {
            //先卖出，才能买
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }
    public static void main(String[] args){
        System.out.println(maxProfit(new int[]{5,4,3,2}));
    }
}
