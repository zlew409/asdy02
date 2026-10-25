import java.util.Arrays;
public class Graph {
    node[] nodes = new node[10];
    edge[] edges = new edge[16];
    int nodeCount = 0;
    int edgeCount = 0;



    public void addNode(String name) {
        nodes[nodeCount] = new node(name);
        nodeCount++;
    }
    public void addEdge(String ends, int val) {
        edges[edgeCount] = new edge(ends, val);
        edgeCount++;
    }

    public void getNodes(edge e) {
        String first = e.ends.substring(0, 1);
        String second = e.ends.substring(1, 2);
        checkAndAddNode(first);
        checkAndAddNode(second);
    }

    public void checkAndAddNode(String vertexName) {
        boolean exists = false;

        for (node nd : nodes) {
            if (nd.name.equals(vertexName)) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            addNode(vertexName);
        }
    }

}