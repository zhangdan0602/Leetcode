package code028_ImplementstrStr;

import java.util.ArrayList;
import java.util.List;

public class BaoyanNo1 {
	public static int strStr(String haystack, String needle) {
		// 子串长度为0，返回0
		if (needle.length() == 0) {
			return 0;
		}
		// 子串或者母串为空，返回-1
		if (haystack == null || needle == null) {
			return -1;
		}
		// 子串的个数
		int j = needle.length(), count = 0;
		List<Integer> location = new ArrayList<>();
		// 循环母串，到子串长度前停止
		for (int h = 0; h < haystack.length() - needle.length() + 1; h++) {
			// 使用substring判断是否有子串；注意左闭右开，右侧需要+1
			// substring长度为：end-begin
			if (haystack.substring(h, j + h).equals(needle)) {
				// 保研机考第一题：递归删除子串【substring】，删除次数【count】；
				count++;
				haystack = haystack.substring(0, h) + haystack.substring(h + j, haystack.length());
				// 删除位置【递归删除子串：位置为新字符串；不递归：位置为原始字符串】
				location.add(h);
			}
		}
		System.out.println(count);
		// 不递归的话，可以replaceAll
		// haystack = haystack.replaceAll(needle, "");
		// 递归删除子串后的字符串
		System.out.println(haystack);
		for (int i = 0; i < location.size(); i++) {
			System.out.print(location.get(i) + ";");
		}
		return count;
	}

	public static void main(String[] args) {
		strStr("hellollo", "ll");
	}
}
