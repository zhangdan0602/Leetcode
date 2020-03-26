package 算法分析与设计.动态规划;

public class Match
{
    public boolean isMatch(String s, String p) {
        int lenS = s.length(), lenP = p.length();
        if(s.equals(p) || p.equals("*"))
            return true;
        if(s == null || p == null)
            return false;
        boolean[][] dp = new boolean[lenS + 1][lenP + 1];
        dp[0][0] = true;
        for(int indexP = 1; indexP < lenP + 1; indexP++){
            if(p.charAt(indexP - 1) == '*'){
                int indexS = 1;
                while((!dp[indexS - 1][indexP - 1]) && (indexS < lenS + 1))
                    indexS++;
                dp[indexS - 1][indexP] = dp[indexS - 1][indexP - 1];
                while(indexS < lenS + 1){
                    dp[indexS++][indexP] = true;
                }

            }else if(p.charAt(indexP - 1) == '?'){
                for(int indexS = 1; indexS < lenS + 1; indexS++){
                    dp[indexS][indexP] = dp[indexS - 1][indexP - 1];
                }
            }else{
                for(int indexS = 1; indexS < lenS + 1; indexS++)
                    dp[indexS][indexP] = (dp[indexS - 1][indexP - 1])&&(s.charAt(indexS - 1) == p.charAt(indexP - 1));
            }
        }
        return dp[lenS][lenP];
    }
    public void print(boolean[][] left){
        for (int i = 0; i < left.length; i++)
        {
            for (int j = 0; j < left[i].length; j++)
            {
                System.out.print(String.valueOf(left[i][j]) + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Match match = new Match();
        System.out.println(match.isMatch("adcbdk", "*a*b?k"));
    }
}
