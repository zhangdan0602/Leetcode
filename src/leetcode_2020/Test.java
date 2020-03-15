package leetcode_2020;

import java.io.*;
import java.util.*;

public class Test
{
    /*
    *
    * 大文件内容排序
用有限内存（比如256MB），处理一个大文件（比如4GB），该文件每行都只有一个全局不重复的乱序数字（正整数），排序好输出到一个新的文件。
为了节约时间，定义大文件是：100w行，内存能处理1w行（排序+输出）
第一步：按要求生成一个文件input.txt
第二步：按题目要求处理该文件，最终输出成output.txt
第三步：统计排序算法的耗时，通过并发编程，在确保结果争取的基础上，如何减少耗时。
*/
    public static void readData() throws IOException
    {
        //1. 生成文件
        HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
        HashMap<Integer, Boolean> flag = new HashMap<>();
        List<List<Integer>> numbersList = new ArrayList<>();
        File f = new File("input.txt");
        InputStream inputStream = new FileInputStream(f);
        if (f.exists())
        {
            byte[] data = new byte[1024];
            int len = inputStream.read(data);
            String dataString = new String(data, 0, len);
            String strings[]= dataString.split("\n");
            for (int i = 0; i < strings.length; i++)
            {
                int num = Integer.valueOf(strings[i]);
                // 每个链表中存mod结果相同的数值
                int key = num % 1000;
                numbersList.get(key).add(num);
                hashMap.put(key, numbersList.get(key));
            }
        }
        // 2 每一个链表排序
        for (HashMap.Entry<Integer, List<Integer>> entry: hashMap.entrySet()){
            List<Integer> list = entry.getValue();
            Collections.sort(list);
            // 3. 写入文件
            File writeFile = new File(String.valueOf(entry.getKey()) + ".txt");
            if (!writeFile.exists()){
                f.createNewFile();
            }
            FileWriter fw = new FileWriter(writeFile.getName(), true);
            for (int i = 0; i < list.size(); i++)
            {
                fw.write(list.get(i));
            }
            fw.close();
        }
        Set<Integer> keys = hashMap.keySet();
        File output = new File("output.txt");
        FileWriter res = new FileWriter(output.getName(), true);
        if (!output.exists()){
            output.createNewFile();
        }
        // 4. 聚合文件
        Iterator<Integer> iter = keys.iterator();
        while (iter.hasNext()){
            File d = new File(String.valueOf(iter.next()) + ".txt");
            InputStream inputStream1 = new FileInputStream(d);
            byte[] data = new byte[1024];
            int len = inputStream1.read(data);
            String s = new String(data, 0, len);
            String strings[]= s.split("\n");
            for (int i = 0; i < strings.length; i++){
                res.write(strings[i]);
            }
        }
        res.close();
    }
    public static void main(String args[]) throws IOException
    {
        readData();
        String s = "123";
    }
}
