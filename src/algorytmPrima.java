public class algorytmPrima {
    Graph g;
    algorytmKruksala(Graph g){
        this.g = g;
    }
    Graph tree = new Graph();

    public void runPrim(node n){
        boolean[] visited = new boolean[g.nodeCount];
        int index = -1;
        minHeap pq = new minHeap();
        for(int i=0;i<g.nodeCount;i++){
            if(g.nodes[i].name == n.name) {
                index = i;
                break;
            }
        }

        for(int i=0;i<g.edgeCount;i++){
            if(g.edges[i].ends.substring(0,1).equals(n.name)||g.edges[i].ends.substring(1,2).equals(n.name)){
                pq.addEdge(g.edges[i].ends,g.edges[i].val);
            }
        }

        while(!pq.isEmpty()){
            edge e = pq.delEdge();

        }
    }

}
