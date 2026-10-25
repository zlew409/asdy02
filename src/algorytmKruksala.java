public class algorytmKruksala {
    Graph g;
    algorytmKruksala(Graph g){
        this.g = g;
    }
    Graph tree = new Graph();

    minHeap pq = new minHeap();
    public void runKruksal(){
        for (int i = 0; i < g.edgeCount; i++) {
            pq.addEdge(g.edges[i].ends, g.edges[i].val);
        }
        while(!pq.isEmpty()){
            edge e = pq.delEdge();
            if("ZAMYKA CYKL"){
                tree.addEdge(e.ends,e.val);
                tree.getNodes(e);
            }
        }
    }
}