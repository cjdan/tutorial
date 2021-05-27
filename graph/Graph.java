package tutorial.graph;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private ArrayList<String> vertextList;//存储顶点集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdges;//表示边的个数
    private boolean[] isVisited;//定义数组，记录某个结点是否被访问过
    public static void main(String[] args) {
        //测试代码
        int n = 6;
        String[] Vertext ={"A","B","C","D","E","F"};
        //创建图对象
        Graph graph = new Graph(n);
        for(String vertext: Vertext){
            graph.insertVertex(vertext);
        }
        //添加边
        //A-B,A-C,B-C,B-D,B-E
        graph.insertEdge(0,1,1);//A-B
        graph.insertEdge(0,2,1);//A-C
        graph.insertEdge(1,2,1);//B-C
        graph.insertEdge(1,3,1);//B-D
        graph.insertEdge(1,4,1);//B-E
        graph.insertEdge(3,4,1);//D-E
        graph.insertEdge(4,5,1);//E-F
        graph.insertEdge(3,5,1);//D-F
        graph.insertEdge(1,5,2);//A-F
        System.out.println(graph.getWeight(1,5));
        //显示矩阵
        graph.shouGraph();
        //深度优先遍历
        System.out.println("深度优先遍历" );
        graph.bfs();



    }

    //构造器
    public Graph(int n){
        //初始化矩阵与vertextList
        edges = new int[n][n];
        vertextList = new ArrayList<String>(n);
        numOfEdges = 0;//初始化为0
        isVisited = new boolean[n];
    }
    //图中常用的方法
    //1.返回节点的个数
    public int getNumOfVertext(){
        return vertextList.size();
    }
    //2.获得边的方法
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //3.返回节点i对应的数据,0->A,1->B,2->C
    public String getValueByIndex(int i){
        return vertextList.get(i);
    }
    //4.返回v1与v2的权值
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }
    //5.显示图对应的矩阵
    public void shouGraph(){
        for (int[] link:edges){
            System.out.println(Arrays.toString(link));
        }
    }
    //得到第一个邻接结点的下标w
    //如果存在就返回对应的下标，否则返回-1；
    public int getFirstNeighbor(int index){
        for(int j = 0;j < vertextList.size();j++){
            if(edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }
    //根据前一个邻接结点的下标，来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2){
        for(int j = v2+1;j < vertextList.size();j++){
            if(edges[v1][j]>0){
                return j;
            }
        }
        return -1;
    }
    //深度优先遍历算法
    //i,第一次就为0
    private void dfs(boolean[] isVisited,int i){
        //访问该结点，输出
        System.out.print(getValueByIndex(i)+"->");
        //将该结点设置为已访问
        isVisited[i] = true;
        int w = getFirstNeighbor(i);//查找结点i第一个邻接点w
        while (w != -1){//说明有邻接结点
            if(!isVisited[w]){
                dfs(isVisited,w);
            }
            //如果w被访问过
            w = getNextNeighbor(i,w);//
        }
    }
    //对dfs进行重载
    public void dfs(){
        //遍历所有结点，进行dfs[回溯]
        for(int i = 0;i < getNumOfVertext();i++){
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    //对一个节点广度优先遍历算法
    private void bfs(boolean[] isVisited,int i){
        int u;//队列头结点对应的下标
        int w;//邻节结点
        LinkedList<Integer> queue = new LinkedList<>();//队列，结点访问的顺序
        //访问结点
        System.out.print(getValueByIndex(i)+"->");
        //标记已经访问
        isVisited[i]=true;
        //将结点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()){
            //取出队列的头结点下标
            u = queue.removeFirst();
            //得到第一个邻结点的下标w
            w = getFirstNeighbor(u);
            while (w !=- 1){
                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w)+"->");
                    isVisited[w] = true;//标记已访问
                    queue.addLast(w);//入队列
                }else {
                    //以 u 为前驱结点，找到 w 后面的下一个邻结点
                    w = getNextNeighbor(u,w);//体现广度优先
                }
            }
        }
    }

    //对bfs进行重载
    public void bfs(){
        //遍历所有结点，进行dfs[回溯]
        for(int i = 0;i < getNumOfVertext();i++){
            if(!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }


    //插入结点
    public void insertVertex(String vertext){
        vertextList.add(vertext);
    }
    //添加边
    //v1表示点的下标,第几个顶点"A"-"B" "A"->0,"B"->1
    //v2第二个顶点对应的下标
    //weight 表示权值
    public void insertEdge(int v1,int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
