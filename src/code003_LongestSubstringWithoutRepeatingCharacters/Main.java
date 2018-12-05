package code003_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
            	//发现重复子串时，i直接变为该重复字符上次出现的位置+1
                i = Math.max(map.get(s.charAt(j)), i);
            }
            //不断地获取长度，即使出现重复字符后，i增大，自然ans减小
            ans = Math.max(ans, j - i + 1);
            //map不断放值，和size无关，只和索引有关
            map.put(s.charAt(j), j + 1);
            System.out.println("j="+j+";i="+i);
        }
        return ans;
        
        /*
		Set<Character> substr = new HashSet<>();
		//一定需要两个变量i和j，表示字符串开始和结束的索引
		int j = 0,i=0,max=0;// include length=0
		while (j < s.length()&&i<s.length()) {
				if (!substr.contains(s.charAt(j))) {
					//通过j不断地遍历S，重复串时会停留。
					substr.add(s.charAt(j++));
					//即使i不断地变化，长度会通过max保存
					max = Math.max(max, j - i);
				} else {
					//当出现重复字符时，开始索引向前滑动
					substr.remove(s.charAt(i++));
				}
		}
		return max;
		*/
		
	}

	public static void main(String[] args) {
		lengthOfLongestSubstring("wekea");
	}
}
