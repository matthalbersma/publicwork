import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by walter on 9/15/16.
 */
public class BFS {
    private Queue<Node> queue;
    static ArrayList<Node> nodes=new ArrayList<>();
    static class Node {
        int data;
        boolean visited;
        Node(int data){
            this.data=data;
        }
    }
    public BFS {
        queue= new LinkedList<Node>()
    }
    public ArrayList<Node> findNeighbours(int adjaceny_matrix [] [], Node x){
        int nodeIndex=-1;
        ArrayList<Node> neighbors=new ArrayList<>();
        for (int i=0;i<nodes.size(); i++){
            if (nodes.get(i).equals(x)){
                nodeIndex=i;
                break;
            }
        }
        if nodeIndex!=-1 {
            for (int j=0; j<adjaceny_matrix[nodeIndex].length; j++){
                if (adjaceny_matrix[nodeIndex][j]==1) {
                    neighbors.add(nodes.get(j));
                }
            }
        }
        return neighbors
    }
    public void bfs(int adjaceny_matrix[][], Node node){
        queue.add(node);
        node.visited=true;
        while (!queue.isEmpty()){
            Node element=queue.remove();
            System.out.println();
        }
    }






}
