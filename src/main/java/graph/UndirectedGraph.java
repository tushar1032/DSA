package graph;

import java.util.*;

public class UndirectedGraph {

    private class Vertex {
        int val;
        boolean visited;

        public Vertex(int val) {
            this.val = val;
            visited = false;
        }
    }

    private int vertexCount;
    private int[][] adj;
    private Vertex[] vertices;
    private int maxVertices;
    private Queue<Integer> queue;
    private Stack<Integer> stack;

    public UndirectedGraph(int maxVertices) {
        this.vertices = new Vertex[maxVertices];
        this.maxVertices = maxVertices;
        this.adj = new int[maxVertices][maxVertices];
        queue = new LinkedList<>();
        stack = new Stack<>();
    }

    public int addVertices(int count) {
        if((vertexCount + count) < maxVertices) {
            for(int i = 0;i < count;i++) {
                vertices[vertexCount + i] = new Vertex(vertexCount + i);
            }
            return vertexCount;
        }
        return -1;
    }

    public void addEdge(int u,int v) {
        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    public List<Integer> DFS() {
        List<Integer> res = new ArrayList<>();
        stack.push(0);
        vertices[0].visited = true;
        res.add(0);
        while(!stack.isEmpty()) {
            int v = getUnvisitedAdjVertices(stack.peek());
            if(v == -1) {
                stack.pop();
            }
            else {
                vertices[v].visited = true;
                res.add(v);
                stack.push(v);
            }
        }
        return res;
    }

    public List<Integer> BFS() {
        List<Integer> res = new ArrayList<>();
        queue.add(0);
        vertices[0].visited = true;
        res.add(0);
        while(!queue.isEmpty()) {
            int w = getUnvisitedAdjVertices(queue.peek());
            if(w == -1) {
                queue.remove();
            }
            else {
                vertices[w].visited = true;
                res.add(w);
                queue.add(w);
            }
        }
        return res;
    }



    private int getUnvisitedAdjVertices(int v) {
        for(int i = 0;i < maxVertices;i ++) {
            if(adj[v][i] == 1 && !vertices[i].visited) {
                return i;
            }
        }
        return -1;
    }

}
