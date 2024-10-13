package org.example;

import java.util.Arrays;
import java.util.HashSet;

public class VerticesConnection {
    private HashSet<String> vertices;

    public VerticesConnection(String[] connection) {
        this.vertices = new HashSet<>(Arrays.asList(connection));
    }

    public HashSet<String> getVertices() {
        return vertices;
    }
}
