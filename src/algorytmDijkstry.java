public class algorytmDijkstry {
    Graph g;
    algorytmDijkstry(Graph g){
        this.g = g;
    }

    public void runDijkstra(String startNodeName){
        int[] distances = new int[g.nodeCount];
        boolean[] visited = new boolean[g.nodeCount];
        for (int i = 0; i < g.nodeCount; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        int startIndex = -1;
        for (int i = 0; i < g.nodeCount; i++) {
            if (g.nodes[i].name.equals(startNodeName)) {
                startIndex = i;
                break;
            }
        }
        if(startIndex==-1) return;
        distances[startIndex] = 0;

        minHeap pq = new minHeap();
        pq.addEdge(startNodeName, 0);

        while(!pq.isEmpty()) {
            edge current = pq.delEdge();
            String uName = current.ends;
            int uDist = current.val;

            int uIndex = -1;
            for (int i = 0; i < g.nodeCount; i++) {
                if (g.nodes[i].name.equals(uName)) {
                    uIndex = i;
                    break;
                }
            }

            if (uIndex == -1 || visited[uIndex]) continue;
            visited[uIndex] = true;

            for (int i = 0; i < g.edgeCount; i++) {
                edge edgeObj = g.edges[i];

                String v1 = edgeObj.ends.substring(0, 1);
                String v2 = edgeObj.ends.substring(1, 2);

                String neighborName = null;
                if (v1.equals(uName)) {
                    neighborName = v2;
                } else if (v2.equals(uName)) {
                    neighborName = v1;
                }

                if (neighborName != null) {
                    int neighborIndex = -1;
                    for (int j = 0; j < g.nodeCount; j++) {
                        if (g.nodes[j].name.equals(neighborName)) {
                            neighborIndex = j;
                            break;
                        }
                    }
                    if (neighborIndex != -1 && !visited[neighborIndex]) {
                        int weight = edgeObj.val;
                        if (distances[uIndex] + weight < distances[neighborIndex]) {
                            distances[neighborIndex] = distances[uIndex] + weight;
                            pq.addEdge(neighborName, distances[neighborIndex]);
                        }
                    }
                }
            }

        }
        for (int i = 0; i < g.nodeCount; i++) {
            System.out.println("Do wierzchołka " + g.nodes[i].name + " odległość wynosi: " + distances[i]);
        }
    }
}








