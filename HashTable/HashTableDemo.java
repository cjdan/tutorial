package tutorial.HashTable;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
        //创建HashTab
        HashTab hashTab = new HashTab(7);
        //写一个简单的程序
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.out.println("退出");
                default:
                    break;

            }
        }


    }
}
class Emp{
    public int id;
    public String name;
    public Emp next;//默认为空

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
//创建EmpLinkedList
class EmpLinkedList{
    //头指针，指向第一个雇员，因此链表的head是直接指向第一个雇员
    private Emp head;//默认null
    //添加雇员到链表
    //假定：1.添加雇员时，id自增长，id的分配总是从小到大
    //因此将该雇员加入到本链表的最后即可
    public void add(Emp emp){
        //如果添加第一个雇员
        if(head==null){
            head = emp;
        }
        //如果不是第一个，则添加一个指针，指向最后一个
        Emp curEmp = head;
        //到链表的最后
        while (curEmp.next != null) {
            curEmp = curEmp.next;//后移
        }
        curEmp.next = emp;//添加到链表最后
    }

    public void list(){
        if (head==null){
            System.out.println("当前链表为空");
            return;
        }
        System.out.println("当前链表为");
        Emp curEmp = head;
        while (curEmp.next!=null){
            System.out.println("id = "+curEmp.id+", name = "+curEmp.name);
            curEmp = curEmp.next;
        }

    }

}
class HashTab{
    private  int size ;//表示共有多少条信息
    private final EmpLinkedList[] empLinkedListArray;

    //构造器
    public HashTab(int size){
        this.size = size;
        //初始化
        empLinkedListArray = new EmpLinkedList[size];
        //不要忘了分别初始化每个链表
        for (int i=0;i<size;i++){
            empLinkedListArray[i] = new EmpLinkedList();
        }

    }
    public int hashFun(int id){
        return id % size;
    }
    public void add(Emp emp){
        //根据员工ID，判断员工应该加入到那一条链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp添加到对应的链表中
//        HashTab[] empLinkedListArray = new HashTab[0];
        empLinkedListArray[empLinkedListNo].add(emp);
    }
    public void list(){
        for (int i=0;i<size;i++){
            empLinkedListArray[i].list();
        }
    }


}
