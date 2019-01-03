package Common;

public class StringCommonMethod {
	public static void main(StringCommonMethod[] args) {
		String str = "abc";
		System.out.println("判断字符串是否相等："+str.equals("abc"));
		System.out.println("忽略大小写，判断字符串是否相等"+str.equalsIgnoreCase("ABC"));
		System.out.println("获得指定索引位置的字符："+str.charAt(0));
		System.out.println("字符串是否包含某连续子串："+str.contains("ac"));
		System.out.println("字符串比较：给定字符串-参数字符串=结果："+str.compareTo("ae"));
		System.out.println("忽略大小写，比较字符串："+str.compareToIgnoreCase("E"));
		System.out.println("字符数组转换为字符串："+str.copyValueOf(new char[]{'b','c','d'}));
        char[] str1=new char[2];
        str.getChars(0, 2, str1, 0);
		System.out.print("字符串转换为字符数组："+ "");
		System.out.println(str1);
		System.out.println("字符串转换为字符数组[加注释返回地址，不加返回值]："+ str.toCharArray());
		System.out.println("从起始位置获得子串："+str.substring(0));
		System.out.println("子串：不包含结束索引："+str.substring(0, 1));
		System.out.println("字符串的哈希吗："+str.hashCode());
		
		
		System.out.println("字符串中第一次出现某个数字字符的索引，没有返回-1："+str.indexOf(1));
		System.out.println("字符串中第一次出现某个数字字符【-97】的索引，没有返回-1："+str.indexOf(98));
		System.out.println("字符串中第一次出现某个字符的索引，没有返回-1："+str.indexOf('b'));
		System.out.println("字符串中第一次出现某个字符的索引，没有返回-1："+str.indexOf("ab"));
		System.out.println("字符串中从某一位置开始，第一次出现某个字符的索引，没有返回-1："+str.indexOf("b",1));
		System.out.println("字符串中最后一次出现某个字符的索引，没有返回-1："+str.lastIndexOf(2));
		
		System.out.println("字符串全转为小写："+str.toLowerCase());
		System.out.println("字符串的长度："+str.length());
		System.out.println("字符串是否匹配正则："+str.matches(".*"));
		System.out.println("字符串某一区域是否匹配另一参数指定区域："+str.regionMatches(0, "ab", 0, 2));
		System.out.println("忽略大小写，字符串某一区域是否匹配另一参数指定区域："+str.regionMatches(true, 0, "AB", 0, 2));
		System.out.println("替换字符串中的某个字符："+str.replace('a', 'b'));
		System.out.println("替换字符串中的某个字符的所有字符："+str.replaceAll("a", "1"));
		System.out.println("替换字符串中的某个字符的第一字符："+str.replaceFirst("a", "1"));
		System.out.println("字符串全转为大写："+str.toUpperCase());
		System.out.println("字符串忽略空白："+str.trim());
		System.out.println("字符串分隔："+str.split("a"));
		System.out.println("连接字符串："+str.concat("ab"));
		System.out.println(""+str.isEmpty());
		System.out.println("字符串的前缀："+str.startsWith("a"));
		System.out.println("字符串从某一位置开始的前缀："+str.startsWith("b",1));
		System.out.println("字符串转为数字："+Integer.parseInt("12"));
		System.out.println("将各个类型的值转换为字符串："+str.valueOf(123));
		System.out.println("将各个类型的值转换为字符串："+Integer.toString(123));
		System.out.println("将各个类型的值转换为字符串："+""+123);
		
	}
}
