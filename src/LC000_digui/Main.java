package LC000_digui;
import java.util.*;
public class Main
{
    public static void reverseString(char[] s){
        if(s.length == 0)
            s = s;
        else{
            for(int j = s.length/2; j < s.length; j++){
                char t = s[j];
                s[j] = s[s.length - j - 1];
                s[s.length - j - 1] = t;
            }
        }
    }
    public static void main(String[] args){
        reverseString(new char[]{'0','1','2','3','4'});
    }
}




