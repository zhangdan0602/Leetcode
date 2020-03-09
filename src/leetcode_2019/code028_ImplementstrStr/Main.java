package leetcode_2019.code028_ImplementstrStr;

public class Main {
	public static int strStr(String haystack, String needle) {
		// 子串长度为0，返回0
		if (needle.length() == 0) {
			return 0;
		}
		// 子串或者母串为空，返回-1
		if (haystack == null || needle == null) {
			return -1;
		}
		int j = needle.length();
		
		// 循环母串，到子串长度前停止
		for (int h = 0; h < haystack.length() - needle.length() + 1; h++) {
			// 使用substring判断是否有子串；注意左闭右开，右侧需要+1
			// j每次都会自增，不满足就会i自增;h+j和j++等同效果【j保持不变；h++相当于j++】。
			if (haystack.substring(h, h+j).equals(needle)) {
				System.out.println(h);
				// 找到第一个位置就可以return
				return h;
			}
		}
		/*
		int i=0;
		while(i<haystack.length()-j+1){
			if (haystack.substring(i, i+j).equals(needle)) {
				System.out.println(i);
				return i;
			}else{
				i++;
			}
		}*/
		// 没有找到，return：-1
		return -1;
	}

	public static void main(String[] args) {
		strStr("hellollo", "llo");
	}
}
