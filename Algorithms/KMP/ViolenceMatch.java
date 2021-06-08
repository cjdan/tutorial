package tutorial.Algorithms.KMP;

public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "尚硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";
        long startTime = System.currentTimeMillis(); //获取开始时间
        System.out.println(violenceMatch(str1,str2));
        long endtime = System.currentTimeMillis(); //获取开始时间
        System.out.println("时间为："+(endtime - startTime));

    }
    //暴力匹配
    public static int violenceMatch(String str1, String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int s1Len = s1.length;
        int s2Len = s2.length;
        int i = 0;//指向s1的索引
        int j = 0;//指向s2的索引
        while (i<s1Len && j < s2Len){//保证匹配不越界.
            if (s1[i] == s2[j]){
                i++;
                j++;
            }else {//没有匹配成功
                i = i - j +1;
                j = 0;
            }
        }
        if (j==s2Len){
            return i -j;
        }else {
            return -1;
        }
    }
}
