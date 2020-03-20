package Point_to_Offer_Version1.数学;

public class P223_43_DicesProbability
{
    /*
    * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
    */
    public double[] twoSum(int n){
        double[] dp = new double[6 * n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++)
        {
            for (int j = i * 6; j >= i; j--)
            {
                dp[j] = 0;
                for (int k = i - 1; k < j && k <= (i - 1) * 6; k++)
                {
                    if (j - k <= 6){
                        dp[j] += dp[k] * 1.0 / 6;
                    }
                }
            }
        }
        double[] res = new double[6 * n - n + 1];
        for (int i = 0; i < res.length; i++)
        {
            res[i] = dp[i + n];
        }
        return res;
    }
    public static void main(String[] args){
        P223_43_DicesProbability dicesProbability = new P223_43_DicesProbability();
        double[] res = dicesProbability.twoSum(2);
        for (double r:res)
        {
            System.out.println(r);
        }
    }
}
