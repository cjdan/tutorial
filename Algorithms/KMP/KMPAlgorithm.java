package tutorial.Algorithms.KMP;

import java.util.Arrays;

public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1= "BBC ABCDAB ABCDABCDABEABCDABDE";
        String str2 = "ABCDABD";
        int[] next = kmpNext(str2);
//        System.out.println(Arrays.toString(next));
        System.out.println(kmpSearch(str1,str2,next));
    }
    //a ab aba abab
    //abab bab ab b
    //获取一个字符串的部分匹配值
    public static int[] kmpNext(String str){
        //创建一个next数组保存部分匹配值
        int[] next = new int[str.length()];
        next[0] = 0;//如果字符串长度为1
        for (int i = 1,j = 0;i < str.length();i++){
            //当二者不等时，需要从next[j -1]获取新的j
            //直到发现有条件成立时退出
            while (j > 0 && str.charAt(i) != str.charAt(j)){
                j = next[j-1];
            }
            if(str.charAt(i)==str.charAt(j)){//条件满足时，部分匹配值就是+1;
                j++;
            }
            next[i] =j;
        }
        return next;
    }
    /*
    * str1:源字符串
    * str2:子串
    * next:部分匹配表，是子串对应的对应的部分匹配表
    * 返回值为-1，表示未匹配，
    */
    public static int kmpSearch(String str1,String str2,int[] next){
        for(int i=0,j=0;i<str1.length();i++){
            while (j>0&&str1.charAt(i)!=str2.charAt(j)){
                j = next[j-1];
            }
            if (str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if (j==str2.length()){//找到了
                return i-j+1;
            }
        }
        return -1;

    }
}
