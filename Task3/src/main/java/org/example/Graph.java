package org.example;

import java.util.HashSet;

public class Graph {

    private HashSet<String> vertices;

    public Graph(HashSet<String> vertices) {
        this.vertices = vertices;
    }

    public Graph(VerticesConnection connection) {
        this.vertices = connection.getVertices();
    }

    public HashSet<String> getVertices() {
        return vertices;
    }

    public boolean checkIfGrafContainsVerticies(VerticesConnection connection) {
        HashSet<String> connectionVer = connection.getVertices();
        HashSet<String> graphVer = new HashSet<>(this.vertices);
        for (String s : connectionVer) {
            if (!graphVer.add(s)) {
                return true;
            }
        }
        return false;
    }

    public Graph addConnectionVerticies(VerticesConnection connection) {
        HashSet<String> connectionVer = connection.getVertices();
        HashSet<String> graphVer = this.vertices;
        for (String ver : connectionVer) {
            graphVer.add(ver);
        }
        return this;
    }
}

