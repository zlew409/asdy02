void main() {

    Graph g = new Graph();
    g.addNode("A");
    g.addEdge("AB",1);
    g.addEdge("AC",2);
    g.addNode("B");
    g.addEdge("BC",1);
    g.addEdge("BE",4);
    g.addEdge("BF",3);
    g.addNode("C");
    g.addEdge("CE",6);
    g.addEdge("CD",4);
    g.addNode("D");
    g.addEdge("DE",5);
    g.addNode("E");
    g.addEdge("EF",5);
    g.addEdge("EG",1);
    g.addNode("F");
    g.addEdge("FG",2);
    g.addNode("G");
    algorytmDijkstry d = new algorytmDijkstry(g);
    d.runDijkstra("A");




}
