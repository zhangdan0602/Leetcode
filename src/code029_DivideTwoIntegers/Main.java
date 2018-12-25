package code029_DivideTwoIntegers;

public class Main {
	public static int divide(int dividend, int divisor) {
		
		//采用减法的位移代替除法。
		
		//注意特殊情况
		if (divisor == 0) {
			return 0;
		}
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		//除数为1 
		if (divisor == 1) {
			return dividend;
		}
		//除数为-1
		if (divisor == -1) {
			//被除数为min【已经规定了除数和被除数的范围】
			if (dividend == min) {
				//直接返回max
				return max;
			} else {
				//返回被除数的相反值
				return -dividend;
			}
		}
		//处理最大最小值取abs的情况。必须转long 如果dividend = Integer.MIN_VALUE时，转为abs就会溢出。
		long divid=(long)dividend;
		long divis=(long)divisor;
		boolean flag = true;
		//处理符号，保持被除数和除数符号统一时，为true，不统一时为false，而且都转为正数操作。
		if (divid < 0) {
			//divid = Math.abs(divid);
			divid = -divid;
			if (divis < 0) {
				//divis = Math.abs(divis);
				divis = -divis;
			} else {
				flag = false;
			}
		} else {
			if (divis < 0) {
				//divis = Math.abs(divis);
				divis = -divis;
				flag = false;
			}
		}
		//定义结果变量、除数*2变量、rs*2变量。
		long rs = 0, divisor_2 = 0, count_2 = 0;
		//除数小于被除数【被除数会改变】
		while (divis <= divid) {
			//初始化时 rs*2=1
			count_2 = 1;
			//初始化时 除数*2=1
			divisor_2 = divis;
			//除数*2小于被除数【除数*2大于被除数时停止while】
			while (divisor_2 <= divid) {
				//除数*2
				divisor_2 <<= 1;
				//rs*2
				count_2 <<= 1;
			}
			//rs加上count／2【因为*2会大于被除数，需要／2，返回一步】
			rs += (count_2 >>= 1);
			//被除数减去除数／2【因为除数*2会大于被除数，需要／2，返回一步】【除数小于被除数，继续while】
			divid -= (divisor_2 >>= 1);
		}
		//return (int)(flag?rs:-rs);
		//按照flag为true／false，返回rs
		return flag?(int)rs:(int)-rs;
	}

	public static void main(String[] args) {
		divide(13, 4);
	}
}
