package org.example;

import java.util.*;

public class GraphsFinder {

    public void showNumberOfGraphs(String[] input) {

        Set<Graph> graphs = new HashSet<>();
        for (int i = 1; i < input.length; i++) {
            String[] verticies = input[i].split(" ");
            VerticesConnection connection = new VerticesConnection(verticies);
            if (graphs.isEmpty()) {
                graphs.add(new Graph(connection));
            } else {
                int flag = 0;
                ArrayList<Graph> graphsToMerge = new ArrayList<>();
                for (Graph graph : graphs) {
                    if (graph.checkIfGrafContainsVerticies(connection)) {
                        graph.addConnectionVerticies(connection);
                        flag++;
                        graphsToMerge.add(graph);
                    }
                }
                if (flag == 0) {
                    graphs.add(new Graph(connection));
                } else if (flag == 2) {
                    for(Graph graph: graphsToMerge){
                        graphs.remove(graph);
                    }
                    graphs.add(mergeGraphs(graphsToMerge));
                }
            }
        }
        System.out.println(graphs.size());
    }

    public Graph mergeGraphs(ArrayList<Graph> list) {
        HashSet<String> graph1Set = list.get(0).getVertices();
        HashSet<String> graph2Set = list.get(1).getVertices();
        for (String ver : graph2Set) {
            graph1Set.add(ver);
        }
        return new Graph(graph1Set);
    }
}
