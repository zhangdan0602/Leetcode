package leetcode_2020;

public class code123_BestTimetoBuyandSellStockII
{
    public static int maxProfit(int[] prices){
        if (prices.length < 1)
            return 0;
        int firBuy = Integer.MIN_VALUE, firSell = 0;
        int secBuy = Integer.MIN_VALUE, secSell = 0;
        for (int i = 0; i < prices.length; i++)
        {
            firBuy = Math.max(firBuy, -prices[i]);
            firSell = Math.max(firSell, firBuy + prices[i]);
            secBuy = Math.max(secBuy, firSell - prices[i]);
            secSell = Math.max(secSell, secBuy + prices[i]);
        }
        return secSell;
    }
    public static void main(String[] args){
        System.out.println(maxProfit(new int[]{5,4,3,2}));
    }
}
