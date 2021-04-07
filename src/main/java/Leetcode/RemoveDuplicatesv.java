package Leetcode;

//import static sun.net.www.protocol.http.DigestAuthentication.charArray;

import java.util.ArrayList;

public class RemoveDuplicatesv {
    public static void main(String[] args) {
        Solution16 P= new Solution16();
        String S = "abbaca";
        System.out.println(P.removeDuplicates(S));
    }

}
class Solution16 {
    public String removeDuplicates(String S) {
//        String[] stack = new String[S.length()];
        char[] ss=S.toCharArray();//转为字符数组
        char[] stack1=new char[S.length()];//定义栈
        int i=0,j=0;
        stack1[0]='1';
        while(i<S.length()){
            if(ss[i]==stack1[j]){
                j--;
            }else {
                j++;
                stack1[j] = ss[i];
            }
            i++;
        }
        System.out.println(stack1);
        return stack1.toString();


    }
}
