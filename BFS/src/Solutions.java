import java.io.*;
import java.util.*;

public class Solutions {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int searches=sc.nextInt();
        for (int a=0; a<searches;a++){
            int nodes=sc.nextInt();
            int edges=sc.nextInt();
            boolean adjMatrix[][] = new boolean[nodes + 1][nodes + 1];
            for (int b=0; b<edges; b++){
                int c=sc.nextInt();
                int d=sc.nextInt();
                adjMatrix[c][d]=true;
                adjMatrix[d][c]=true;
            }
            int start=sc.nextInt();
            for (int i = 1; i <= nodes; i++) {
                if (i!=start) {
                    Queue<Integer> Q=new LinkedList<Integer>();
                    Map<Integer, Integer> children=new HashMap<>();
                    ArrayList<Integer> path=new ArrayList<>();
                    if (adjMatrix[start][i]) {
                        System.out.print("6 ");
                    }
                    else {
                        boolean[] visited=new boolean[adjMatrix[start].length];
                        int numNodes=visited.length-1;
                        int  element, x;
                        visited[start]=true;
                        children.put(start, null);
                        Q.add(start);
                        while (!Q.isEmpty()){
                            element=Q.remove();
                            if (element==i) {
                                while(children.get(element)!=null){
                                    path.add(element);
                                    element=children.get(element);

                                } System.out.print(path.size()*6+" ");
                            }

                            for (x=1;x<=numNodes; x++){
                                if ((adjMatrix[element][x])&&!visited[x]){
                                    Q.add(x);
                                    visited[x]=true;
                                    children.put(x, element);
                                }
                            }

                        }System.out.print("-1 ");

                    }
                }
            } System.out.println("");
        }
    }
}