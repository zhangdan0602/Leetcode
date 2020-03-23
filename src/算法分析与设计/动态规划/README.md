## 以最长回文子串ababa/abaaba为例：

## 1. 状态
表格中的cell的含义：

dp[i][j] 表示子串 s[i, j] 是否为回文子串。

## 2. 状态转方程
### 2.1 这一步在做分类讨论（根据头尾字符是否相等），根据上面的分析得到：

dp[i][j] = ((s[i] == s[j]) and dp[i + 1][j - 1])

### 2.2 分析这个状态转移方程：

（1）“动态规划”事实上是在填一张二维表格，i 和 j 的关系是 i <= j ，因此，只需要填这张表的上半部分；

（2）看到 dp[i + 1][j - 1] 就得考虑边界情况。

边界条件是：表达式 [i + 1, j - 1] 不构成区间，即长度严格小于 2，即 j - 1 - (i + 1) + 1 < 2 ，整理得 j - i < 3。

以ababa举例：

i = 1, j = 3; len(s[i, j]) = 3; i + 1 = 2, j - 1 = 2; j - i = 2;

以abaaba举例：
 
i = 2, j = 3; len(s[i, j]) = 2;  i + 1 = 3, j - 1 = 2; j - i = 1;

### 2.3 这个结论很显然：

当子串 s[i, j] 的长度等于 2 或者等于 3 的时候，只需要判断一下头尾两个字符是否相等就可以直接下结论了。

如果子串 s[i + 1, j - 1] 只有 1 个字符 a，即去掉两头，剩下中间部分只有 1 个字符，当然是回文；

如果子串 s[i + 1, j - 1] 为空串，那么子串 s[i, j] 一定是回文子串。

因此，在 s[i] == s[j] 成立和 j - i < 3 的前提下，直接可以下结论，dp[i][j] = true，否则才执行状态转移。


## 3. 初始化
初始化的时候，单个字符一定是回文串，因此把对角线先初始化为 1，即 dp[i][i] = 1 

## 4. 输出
只要得到 dp[i][j] = true，就记录子串的长度和起始位置，没有必要截取，因为截取字符串也要消耗性能.

记录此时的回文子串的“起始位置”和“回文长度”即可

## 5. 压缩
因为在填表的过程中，只参考了左下方的数值。事实上可以压缩，但会增加一些判断语句，增加代码编写和理解的难度，丢失可读性。

## 实例
以"babad"为例,填充dp数组

        0   1   2   3   4
    

    0   T   F   T   F   F

    1       T   F   T   F

    2           T   F   F

    3               T   F

    4                   T
    
 
## 源码
```

public class LongestPalindromeString
{
    public String LongestPalindrome(String s){
        if (s == null || s.length() == 0)
            return s;
        int len = s.length(), maxLength = 1, start = 0;
        boolean dp[][] = new boolean[len][len];
        for (int i = 0; i < len; i++)
        {
            dp[i][i] = true;
        }
        for (int r = 1; r < len; r++)
        {
            for (int l = 0; l < r; l++)
            {
                if (s.charAt(l) == s.charAt(r)){
                    if (r - l < 3){
                        dp[l][r] = true;
                    }else
                        dp[l][r] = dp[l + 1][r - 1];
                }else
                    dp[l][r] = false;

                if (dp[l][r] == true){
                    if (maxLength <= (r - l + 1)){
                        maxLength = r - l + 1;
                        start = l;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
    public static void main(String[] args){
        LongestPalindromeString longestPalindromeString = new LongestPalindromeString();
        System.out.println(longestPalindromeString.LongestPalindrome("ababd"));
    }
}
```
## 说明

1、当  l 和 r 的差距等于小于 3 的时候，dp 值可以直接判断，不用参考以前的 dp 值；

2、其它情况，每当计算新 dp 值的时候，都一定会参考“左下角”的 dp 值，即 dp[i + 1][j - 1]（i + 1 表示在下边，j - 1 表示在左边）。

因此，从上到下写，或者从下到上写，都是可以的。

## 时空复杂度
以空间换时间，都是O(n^2)

## 方向
满足"无后效性"：计算后面状态的值时需要参考的值已经算出来。


