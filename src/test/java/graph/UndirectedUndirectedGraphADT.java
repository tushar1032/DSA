package graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UndirectedUndirectedGraphADT {

    private UndirectedGraph undirectedGraph;

    @Before
    public void init() {
        undirectedGraph = new UndirectedGraph(20);
        undirectedGraph.addVertices(8);
        undirectedGraph.addEdge(0,1);
        undirectedGraph.addEdge(1,2);
        undirectedGraph.addEdge(1,7);
        undirectedGraph.addEdge(2,3);
        undirectedGraph.addEdge(2,4);
        undirectedGraph.addEdge(4,5);
        undirectedGraph.addEdge(4,6);
        undirectedGraph.addEdge(4,7);
    }

    @Test
    public void BFS() {
        List<Integer> res = undirectedGraph.BFS();
        System.out.println(res);
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(7);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);

        Assert.assertEquals(res,expected);
    }

    @Test
    public void DFS() {
        List<Integer> res = undirectedGraph.DFS();
        System.out.println(res);
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);

        Assert.assertEquals(res,expected);
    }

}
