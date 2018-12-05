package code003_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Repeat {
	public static int lengthOfLongestSubstring(String s) {

		Set<Character> str = new HashSet<>();
		int i = 0, j = 0, rs = 0, n = s.length();

		while (i < n && j < n) {
			
			if (!str.contains(s.charAt(j))) {
				str.add(s.charAt(j++));
				rs = Math.max(rs, j - i);
			} else {
				str.remove(s.charAt(i++));
			}
		}
		return rs;
	}

	public static int lengthOfLongestSubstring1(String s) {
		Map<Character, Integer> str=new HashMap<>();
		int rs=0;
		for(int i=0,j=0;j<s.length();j++){
			if(str.containsKey(s.charAt(j))){
				i=Math.max(str.get(s.charAt(j)), i);
			}
			rs=Math.max(rs, j-i+1);
			str.put(s.charAt(j), j+1);
		}
		return 0;
	}
	public static void main(String[] args) {
		lengthOfLongestSubstring("");

	}
}
