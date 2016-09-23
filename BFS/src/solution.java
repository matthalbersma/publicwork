import java.io.*;
import java.util.*;

public class solution {

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
                    System.out.print(bfs(adjMatrix, start, i));
                    System.out.print(" ");
                }
            }System.out.println("");
        }sc.close();
    }

    static int bfs (boolean [] [] adjMatrix, int start, int end){
        Queue<Integer> Q=new LinkedList<Integer>();
        Map<Integer, Integer> children=new HashMap<>();
        int counter=0;
        if (adjMatrix[start][end]) {
            return 6;
        }
        else {
            boolean[] visited=new boolean[adjMatrix[start].length];
            int nodes=visited.length-1;
            int  element, i;
            visited[start]=true;
            children.put(start, null);
            Q.add(start);
            while (!Q.isEmpty()){
                element=Q.remove();
                if (element==end) {
                    while(children.get(element)!=null){
                        counter++;
                        element=children.get(element);
                    } return counter*6;
                }
                for (i=1;i<=nodes; i++){
                    if ((adjMatrix[element][i])&&!visited[i]){
                        Q.add(i);
                        visited[i]=true;
                        children.put(i, element);
                    }
                }
            }
        }return -1;
    }
}