package leetcode_2020.tag001_stack;

/**
 * Created by Zd on 2020/2/10.
 */
public class code025_CountandSay {
    public static String countAndSay(int n) {
        String rs = "1";
        for (int i = 2; i <= n; i++){
            StringBuilder stringBuilder = new StringBuilder();
            char pre = rs.charAt(0);
            int count = 1;
            for (int j = 1; j < rs.length(); j++) {
                char current = rs.charAt(j);
                if (current == pre){
                    count++;
                }else {
                    stringBuilder.append(count).append(pre);
                    pre = current;
                    count = 1;
                }
            }
            stringBuilder.append(count).append(pre);
            rs = stringBuilder.toString();
        }
        return rs;
    }
    public static void main(String args[]){
        System.out.println(countAndSay(5));
    }
}
