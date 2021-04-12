package foundation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class bufferedReader {
    public static void main(String[] args) throws IOException {
        String str;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        Scanner scan = new Scanner(System.in);
        // 读取字符
        do {
            str = br.readLine();
            String str1 = scan.next();
            System.out.println(str+str1);
        } while (!str.equals("end"));
    }
}
