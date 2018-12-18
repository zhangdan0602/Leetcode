package code017_LetterCombinationsofAPhoneNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static List<String> letterCombinations(String digits) {
		//声明电话号码和字母所对应的集合
		List<String> two=new ArrayList(Arrays.asList("a","b","c"));
		List<String> three=new ArrayList(Arrays.asList("d","e","f"));
		List<String> four=new ArrayList(Arrays.asList("g","h","i"));
		List<String> five=new ArrayList(Arrays.asList("j","k","l"));
		List<String> six=new ArrayList(Arrays.asList("m","n","o"));
		List<String> seven=new ArrayList(Arrays.asList("p","q","r","s"));
		List<String> eight=new ArrayList(Arrays.asList("t","u","v"));
		List<String> nine=new ArrayList(Arrays.asList("w","x","y","z"));
		//嵌套存入集合
		List<List<String>> map=new ArrayList(Arrays.asList(two,three,four,five,six,seven,eight,nine));
		//声明结果集合
		List<String> rStrings=new ArrayList<>();
		//边界条件
		if (digits.length()==0) {
			return rStrings;
		}
		//求最后一位电话号码对应的字母集合
		int first=digits.charAt(0)-'0'-2;
		List<String> current=map.get(first);
		if (digits.length()==1) {
			for (int i = 0; i < current.size(); i++) {
				rStrings.add(current.get(i));
			}
			return rStrings;
		}
		//因为循环次数不确定，所以需要使用递归，不断地截取到只剩一个字符
		List<String> leftList=letterCombinations(digits.substring(1));
		for (String aList:current) {
			for(String str:leftList){
				//做一个排列操作
				rStrings.add(aList+str);
			}
		}
		for (int i = 0; i < rStrings.size(); i++) {
			System.out.print(rStrings.get(i)+";");
		}
		//返回排列结果，多个字符时，这个结果将作为后缀继续排列。
		return rStrings;
		
	}

	public static void main(String[] args) {
		letterCombinations("234");
	}
}
