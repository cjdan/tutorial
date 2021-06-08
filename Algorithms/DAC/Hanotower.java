package tutorial.Algorithms.DAC;

public class Hanotower {
    public static void main(String[] args) {
        hanotower(5,'A','B','C');

    }
    //汉罗塔移动方案
    public static void hanotower(int num, char a, char b,char c){
        if (num==1){
            System.out.println("第1个盘:"+a+"->"+c);
        }else {
            //如果n>=2,总是可以看成两个盘1.最下面一个盘2.上面所有的盘
            //1.先把最上面所有盘A->B
            hanotower(num-1,a,b,c);
            //2.把最下面的盘A-C
            System.out.println("第"+num+"个盘:"+a+"->"+c);
            //3.把B塔所有的盘B->C,移动过程使用到A塔1
            hanotower(num-1,b,a,c);
        }
    }
}
