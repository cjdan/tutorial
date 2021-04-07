package Leetcode;

public class Maximum69Number {
    public static void main(String[] args) {
        Maximum69Number1 P = new Maximum69Number1();
        int num = 69669;
        System.out.println(P.maximum69Number(num));

    }
}
class Maximum69Number1 {
    public int maximum69Number(int num) {
        String S = String.valueOf(num);
//        String result = "";
        return Integer.parseInt(S.replaceFirst("6","9"));
//        int index1 = S.indexOf('6');
//        if (index1>=0){
//            result = result + S.substring(0,index1)+'9'+S.substring(index1+1);
//        }else {
//            result = result+S;
//        }
//        return Integer.parseInt(result);

    }
}