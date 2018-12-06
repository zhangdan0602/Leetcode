package code006_ZigZagConversion;

public class Main {
	public static String convert(String s, int numRows) {
		//考虑极端情况
		if (numRows==1) {
			return s;
		}
		char str[][] = new char[numRows][s.length()];
		int k=0;
		//做初始化工作
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < s.length(); j++) {
				str[i][j] ='0';
			}
		}
		for (int j = 0; ; j++) {
			for (int m = 0; m < numRows; m++) {
				if(k==s.length()){
					break;
				}
				//填充每一列数据【满】
				str[m][2*j]=s.charAt(k);
				k++;
				
			}
			//填充稀疏列数据
			for (int n = numRows-2; n >0; n--) {
				if(k==s.length()){
					break;
				}
				str[n][2*j+1]=s.charAt(k);
				k++;
				
			}
			//必须写 否则下述代码不能用
			if(k==s.length()){
				break;
			}
		}
		
		//StringBuffer string=new StringBuffer(); time is longer
		String string="";
		for (int p = 0; p < numRows; p++) {
			for (int q = 0; q < s.length(); q++) {
				if (str[p][q]!='0') {
					 //拼接非0字符
					//string.append(str[p][q]);
					string+=str[p][q];
				}
			}
		}
		//return string.toString();
		return string;
	}
	public static void main(String[] args) {
		convert("", 3);
	}
}
