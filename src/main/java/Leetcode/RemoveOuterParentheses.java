package Leetcode;

import java.util.Stack;

public class RemoveOuterParentheses {
    public static void main(String[] args) {
        RemoveOuterParentheses1 P= new RemoveOuterParentheses1();
        String S = "(()())(())(()(()))";
        System.out.println(P.removeOuterParentheses(S));

    }
}
class RemoveOuterParentheses1 {
    public String removeOuterParentheses(String S) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
//        stack.push(S.substring(0,1));
        for(int i=0;i<S.length();i++){
          if(S.charAt(i) == '('){
              if(stack.size()!=0){
                  result.append(S.charAt(i));
              }
              stack.push(S.substring(i,i+1));
          }else if(S.charAt(i)==')' ){
              if(stack.size()!=1){
                  result.append(S.charAt(i));
              }
              stack.pop();
          }
        }
        return String.valueOf(result);

    }
}