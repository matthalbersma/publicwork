import com.sun.javafx.scene.control.SizeLimitedList;
import com.sun.jdi.IntegerType;

import java.util.*;

import static javafx.scene.input.KeyCode.Q;

/**
 * Created by walter on 9/15/16.
 */
public class BFSstab {
    public static void main(String[] args) {

        int nodes = 10;
        int edges = 6;
        int start = 3;
        boolean adjMatrix[][] = new boolean[nodes + 1][nodes + 1];
        adjMatrix[3][1] = true;
        adjMatrix[1][3] = true;
        adjMatrix[10][1] = true;
        adjMatrix[1][10] = true;
        adjMatrix[1][8] = true;
        adjMatrix[8][1] = true;
        adjMatrix[5][2] = true;
        adjMatrix[2][5] = true;
        for (int i = 1; i <= nodes; i++) {
            if (i!=start) {
                System.out.print(bfs(adjMatrix, start, i));
                System.out.print(" ");
            }
        }


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



