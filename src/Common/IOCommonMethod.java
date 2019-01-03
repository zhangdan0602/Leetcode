package Common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class IOCommonMethod {
	public static void main(String[] args) throws IOException {

		/*
		 * // 控制台输入方法1 BufferedReader reader = new BufferedReader(new
		 * InputStreamReader(System.in)); String line = reader.readLine();
		 * System.out.println(line); // 控制台输入方法2 Scanner scanner = new
		 * Scanner(System.in); line = scanner.nextLine();
		 * System.out.println(line);
		 * 
		 * // 读文件
		 * read("/Users/Zd/Documents/workspace/programs/src/Common/read.txt");
		 * // 写文件
		 * write("/Users/Zd/Documents/workspace/programs/src/Common/write.txt");
		 */
		// 序列化对象
		SerializePerson("/Users/Zd/Documents/workspace/programs/src/Common/person.txt");
		// 对象反序列化
		DeserializePerson("/Users/Zd/Documents/workspace/programs/src/Common/person.txt");
	}

	public static boolean read(String filename) {
		boolean rs = true;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line = "";
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			rs = false;// 找不到文件
		} catch (IOException e) {
			rs = false;// 文件读取错误
		} finally {
			try {
				reader.close();
			} catch (IOException e2) {
				rs = false;// 文件关闭错误
			}
		}
		return rs;
	}

	public static boolean write(String filename) {
		boolean rs = true;
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(filename));
			for (int i = 0; i < 10; i++) {
				writer.write("hello\n");
			}
			writer.flush();
		} catch (FileNotFoundException e) {
			rs = false;
		} catch (IOException e) {
			rs = false;
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				rs = false;
			}
		}
		return rs;
	}

	public static void SerializePerson(String filename) {
		Person person = new Person();
		ObjectOutputStream outputStream = null;
		person.setAge(22);
		person.setName("zd");
		person.setSex("f");
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(filename));
			outputStream.writeObject(person);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void DeserializePerson(String filename) {
		ObjectInputStream inputStream = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(filename));
			try {
				Person person = (Person) inputStream.readObject();
				System.out.println(person.getName());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
